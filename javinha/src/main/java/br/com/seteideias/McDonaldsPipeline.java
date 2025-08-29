package br.com.seteideias;

import java.util.*;

public class McDonaldsPipeline {

    // ==== Domínio ====
    enum ItemType { BURGER, FRIES, DRINK, HAPPY_MEAL }
    static class OrderItem {
        final ItemType type;
        final String name; // ex.: Big Mac, Coca, Batata M, McLanche Feliz
        OrderItem(ItemType type, String name) { this.type = type; this.name = name; }
        @Override public String toString() { return type + "(" + name + ")"; }
    }

    static class OrderRequest {
        final String orderId;
        final String paymentToken;   // "OK" = aprovado
        final boolean wantsToy;      // brinquedo do McLanche Feliz
        final List<OrderItem> items;

        OrderRequest(String orderId, String paymentToken, boolean wantsToy, List<OrderItem> items) {
            this.orderId = orderId;
            this.paymentToken = paymentToken;
            this.wantsToy = wantsToy;
            this.items = items;
        }
    }

    static class OrderContext {
        final OrderRequest req;
        final List<String> logs = new ArrayList<>();
        boolean stopped = false;

        OrderContext(OrderRequest req) { this.req = req; }
        void stop(String reason) {
            logs.add("⛔️ " + reason);
            stopped = true;
        }
    }

    // ==== Contrato e base ====
    interface Handler {
        Handler setNext(Handler next);
        void handle(OrderContext ctx);
    }

    static abstract class AbstractHandler implements Handler {
        private Handler next;
        @Override public Handler setNext(Handler next) { this.next = next; return next; }
        @Override public void handle(OrderContext ctx) {
            if (ctx.stopped) return;
            if (doHandle(ctx) && next != null) next.handle(ctx);
        }
        /** true = continua; false = para (use ctx.stop para justificar) */
        protected abstract boolean doHandle(OrderContext ctx);
    }

    // ==== Handlers concretos ====

    /** Dona Florinda (gerente): checa cardápio/estoque básico e regras (ex.: brinquedo só com Happy Meal). */
    static class MenuAndRulesHandler extends AbstractHandler {
        private final Set<String> menu = Set.of("Big Mac", "Quarteirão", "Coca", "Sprite", "Batata M",
                "Batata G", "McLanche Feliz");
        private final Map<String, Integer> stockByName; // estoque por item simples (didático)

        MenuAndRulesHandler(Map<String, Integer> stockByName) {
            this.stockByName = stockByName;
        }

        @Override
        protected boolean doHandle(OrderContext ctx) {
            for (OrderItem it : ctx.req.items) {
                if (!menu.contains(it.name)) {
                    ctx.logs.add("📋 Item fora do menu: " + it.name);
                    ctx.stop("Item não disponível: " + it.name);
                    return false;
                }
                int qtd = stockByName.getOrDefault(it.name, 0);
                if (qtd <= 0) {
                    ctx.logs.add("📦 Sem estoque: " + it.name);
                    ctx.stop("Sem estoque para: " + it.name);
                    return false;
                }
            }
            // regra do brinquedo
            boolean temHappy = ctx.req.items.stream().anyMatch(i -> i.type == ItemType.HAPPY_MEAL);
            if (ctx.req.wantsToy && !temHappy) {
                ctx.logs.add("🧸 Regras: brinquedo só com McLanche Feliz");
                ctx.stop("Brinquedo requer McLanche Feliz");
                return false;
            }
            ctx.logs.add("✅ Menu/Estoque/Regra OK");
            return true;
        }
    }

    /** Seu Madruga (caixa): autorização de pagamento. */
    static class PaymentHandler extends AbstractHandler {
        @Override
        protected boolean doHandle(OrderContext ctx) {
            boolean ok = "OK".equals(ctx.req.paymentToken);
            ctx.logs.add(ok ? "💳 Pagamento APROVADO" : "💳 Pagamento RECUSADO");
            if (!ok) {
                ctx.stop("Pagamento não autorizado");
                return false;
            }
            return true;
        }
    }

    /** Chaves (batata): só atua se tiver batata no pedido. */
    static class FryStationHandler extends AbstractHandler {
        private final Map<String, Integer> stock;
        FryStationHandler(Map<String, Integer> stock) { this.stock = stock; }

        @Override
        protected boolean doHandle(OrderContext ctx) {
            boolean precisa = ctx.req.items.stream().anyMatch(i -> i.type == ItemType.FRIES);
            if (!precisa) {
                ctx.logs.add("🍟 Sem batata no pedido — pulando estação de fritura");
                return true;
            }
            // Consome 1 unidade da batata (nome ex.: Batata M / Batata G)
            for (OrderItem it : ctx.req.items) {
                if (it.type == ItemType.FRIES) {
                    int qtd = stock.getOrDefault(it.name, 0);
                    if (qtd <= 0) {
                        ctx.logs.add("🍟 Falha: sem " + it.name + " para fritar");
                        ctx.stop("Sem " + it.name);
                        return false;
                    }
                    stock.put(it.name, qtd - 1);
                    ctx.logs.add("🍟 Batata pronta: " + it.name);
                }
            }
            return true;
        }
    }

    /** Quico (bebidas): só atua se tiver bebida. */
    static class DrinkStationHandler extends AbstractHandler {
        private final Map<String, Integer> stock;
        DrinkStationHandler(Map<String, Integer> stock) { this.stock = stock; }

        @Override
        protected boolean doHandle(OrderContext ctx) {
            boolean precisa = ctx.req.items.stream().anyMatch(i -> i.type == ItemType.DRINK);
            if (!precisa) {
                ctx.logs.add("🥤 Sem bebida — pulando estação de bebidas");
                return true;
            }
            for (OrderItem it : ctx.req.items) {
                if (it.type == ItemType.DRINK) {
                    int qtd = stock.getOrDefault(it.name, 0);
                    if (qtd <= 0) {
                        ctx.logs.add("🥤 Falha: sem " + it.name);
                        ctx.stop("Sem " + it.name);
                        return false;
                    }
                    stock.put(it.name, qtd - 1);
                    ctx.logs.add("🥤 Bebida servida: " + it.name);
                }
            }
            return true;
        }
    }

    /** Professor Girafales (chapa): hambúrguer. Happy Meal também passa aqui (tem sanduíche). */
    static class GrillStationHandler extends AbstractHandler {
        private final Map<String, Integer> stock;
        GrillStationHandler(Map<String, Integer> stock) { this.stock = stock; }

        @Override
        protected boolean doHandle(OrderContext ctx) {
            for (OrderItem it : ctx.req.items) {
                if (it.type == ItemType.BURGER || it.type == ItemType.HAPPY_MEAL) {
                    String key = it.name.equals("McLanche Feliz") ? "Hamburguer Infantil" : it.name;
                    int qtd = stock.getOrDefault(key, 0);
                    if (qtd <= 0) {
                        ctx.logs.add("🍔 Falha: sem " + key + " na chapa");
                        ctx.stop("Sem " + key);
                        return false;
                    }
                    stock.put(key, qtd - 1);
                    ctx.logs.add("🍔 Sanduíche pronto: " + it.name);
                }
            }
            return true;
        }
    }

    /** Dona Florinda (gerente) empacota; se pediu brinquedo, inclui. */
    static class AssemblyAndBaggingHandler extends AbstractHandler {
        private final Map<String, Integer> stock; // brinquedos, guardanapos etc.
        AssemblyAndBaggingHandler(Map<String, Integer> stock) { this.stock = stock; }

        @Override
        protected boolean doHandle(OrderContext ctx) {
            if (ctx.req.wantsToy) {
                int brinquedos = stock.getOrDefault("Brinquedo", 0);
                if (brinquedos <= 0) {
                    ctx.logs.add("🧸 Falha: sem brinquedo no estoque");
                    ctx.stop("Sem brinquedo");
                    return false;
                }
                stock.put("Brinquedo", brinquedos - 1);
                ctx.logs.add("🧸 Brinquedo adicionado ao pacote");
            }
            ctx.logs.add("🧾 Pedido empacotado com sucesso");
            return true;
        }
    }

    /** Sr. Barriga: conferência final e liberação. */
    static class ReadyToPickupHandler extends AbstractHandler {
        @Override
        protected boolean doHandle(OrderContext ctx) {
            ctx.logs.add("✅ Pedido pronto para retirada: " + ctx.req.orderId);
            return true;
        }
    }

    // ==== Demonstração ====
    public static void main(String[] args) {
        // Estoques didáticos
        Map<String, Integer> stockMenu = new HashMap<>();
        stockMenu.put("Big Mac", 5);
        stockMenu.put("Quarteirão", 2);
        stockMenu.put("Coca", 10);
        stockMenu.put("Sprite", 0); // acabou Sprite
        stockMenu.put("Batata M", 3);
        stockMenu.put("Batata G", 1);
        stockMenu.put("McLanche Feliz", 4);

        Map<String, Integer> stockGrill = new HashMap<>();
        stockGrill.put("Big Mac", 5);
        stockGrill.put("Quarteirão", 2);
        stockGrill.put("Hamburguer Infantil", 4); // usado pelo McLanche Feliz

        Map<String, Integer> stockFries = new HashMap<>();
        stockFries.put("Batata M", 3);
        stockFries.put("Batata G", 1);

        Map<String, Integer> stockDrinks = new HashMap<>();
        stockDrinks.put("Coca", 10);
        stockDrinks.put("Sprite", 0);

        Map<String, Integer> stockAssembly = new HashMap<>();
        stockAssembly.put("Brinquedo", 2);

        // Monta a cadeia
        Handler chain = new MenuAndRulesHandler(stockMenu);
        chain.setNext(new PaymentHandler())
                .setNext(new FryStationHandler(stockFries))
                .setNext(new DrinkStationHandler(stockDrinks))
                .setNext(new GrillStationHandler(stockGrill))
                .setNext(new AssemblyAndBaggingHandler(stockAssembly))
                .setNext(new ReadyToPickupHandler());

        // Cenário 1: Sucesso (Big Mac + Coca + Batata M)
        run(chain, new OrderRequest(
                "PED-001", "OK", false,
                List.of(new OrderItem(ItemType.BURGER, "Big Mac"),
                        new OrderItem(ItemType.DRINK, "Coca"),
                        new OrderItem(ItemType.FRIES, "Batata M"))));

        // Cenário 2: Sprite esgotada (para a cadeia em bebidas)
        run(chain, new OrderRequest(
                "PED-002", "OK", false,
                List.of(new OrderItem(ItemType.BURGER, "Quarteirão"),
                        new OrderItem(ItemType.DRINK, "Sprite"))));

        // Cenário 3: McLanche Feliz com brinquedo (tudo certo)
        run(chain, new OrderRequest(
                "PED-003", "OK", true,
                List.of(new OrderItem(ItemType.HAPPY_MEAL, "McLanche Feliz"))));

        // Cenário 4: Brinquedo sem McLanche Feliz (regra bloqueia)
        run(chain, new OrderRequest(
                "PED-004", "OK", true,
                List.of(new OrderItem(ItemType.BURGER, "Big Mac"))));

        // Cenário 5: Pagamento recusado
        run(chain, new OrderRequest(
                "PED-005", "FAIL", false,
                List.of(new OrderItem(ItemType.BURGER, "Big Mac"))));
    }

    private static void run(Handler chain, OrderRequest req) {
        OrderContext ctx = new OrderContext(req);
        chain.handle(ctx);

        System.out.println("\n=== Resultado " + req.orderId + " ===");
        ctx.logs.forEach(System.out::println);
        System.out.println(ctx.stopped ? "Resultado: ❌ FALHOU" : "Resultado: ✅ SUCESSO");
    }
}

