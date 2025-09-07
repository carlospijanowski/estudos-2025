package br.com.seteideias.design_patterns.criacionais.factory_method;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.UUID;

public class FactoryMethod {

    // ===== Produto (contrato) =====
    interface Transacao {
        String tipo();
        void validar(BigDecimal valor);
        BigDecimal calcularTaxa(BigDecimal valor);
        void liquidar(BigDecimal valorLiquido, String origem, String destino);
    }

    // ===== Creator (classe base com o fluxo-padrão) =====
    static abstract class TransacaoCreator {
        public final Recibo processarTransacao(BigDecimal valor, String origem, String destino) {
            System.out.println("Cebolinha (Risco): checando limites e fraude...");
            Transacao t = criarTransacao();                 // <-- Factory Method
            t.validar(valor);
            BigDecimal taxa = t.calcularTaxa(valor);
            BigDecimal liquido = valor.subtract(taxa).setScale(2, RoundingMode.HALF_UP);

            System.out.printf("Mônica (Compliance): tipo=%s, valor=%.2f, taxa=%.2f, líquido=%.2f%n",
                    t.tipo(), valor, taxa, liquido);

            t.liquidar(liquido, origem, destino);

            System.out.println("Magali (Notificações): push enviado para o app ✅");

            return new Recibo(
                    UUID.randomUUID().toString(),
                    t.tipo(),
                    valor.setScale(2, RoundingMode.HALF_UP),
                    taxa.setScale(2, RoundingMode.HALF_UP),
                    liquido,
                    origem,
                    destino,
                    Instant.now()
            );
        }

        protected abstract Transacao criarTransacao();      // <-- factory method
    }

    // ===== Produtos concretos =====
    static class PixTransacao implements Transacao {
        public String tipo() { return "PIX"; }
        public void validar(BigDecimal valor) {
            if (valor.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("PIX inválido: valor <= 0");
            System.out.println("Franjinha (Antifraude): chave PIX válida, device confiável.");
        }
        public BigDecimal calcularTaxa(BigDecimal valor) {
            return BigDecimal.ZERO; // PIX entre PF geralmente sem taxa
        }
        public void liquidar(BigDecimal valorLiquido, String origem, String destino) {
            System.out.printf("Cascão (Operações): liquidação IMEDIATA PIX de %s para %s: R$ %.2f%n",
                    origem, destino, valorLiquido);
        }
    }

    static class BoletoTransacao implements Transacao {
        public String tipo() { return "BOLETO"; }
        public void validar(BigDecimal valor) {
            if (valor.compareTo(new BigDecimal("5.00")) < 0) {
                throw new IllegalArgumentException("Boleto mínimo é R$ 5,00");
            }
            System.out.println("Cebolinha (Risco): boleto registrado com verificação de sacado.");
        }
        public BigDecimal calcularTaxa(BigDecimal valor) {
            // taxa fixa R$ 3,50 (exemplo didático)
            return new BigDecimal("3.50");
        }
        public void liquidar(BigDecimal valorLiquido, String origem, String destino) {
            System.out.printf("Cascão (Operações): boleto compensará D+1 para %s; valor líquido: R$ %.2f%n",
                    destino, valorLiquido);
        }
    }

    static class TedTransacao implements Transacao {
        public String tipo() { return "TED"; }
        public void validar(BigDecimal valor) {
            if (valor.compareTo(new BigDecimal("10000")) > 0) {
                System.out.println("Mônica (Compliance): valor alto, aplicando verificação extra KYC.");
            }
            if (valor.signum() <= 0) throw new IllegalArgumentException("TED inválida: valor <= 0");
        }
        public BigDecimal calcularTaxa(BigDecimal valor) {
            // taxa fixa didática
            return new BigDecimal("9.90");
        }
        public void liquidar(BigDecimal valorLiquido, String origem, String destino) {
            System.out.printf("Cascão (Operações): TED agendada ainda hoje de %s para %s: R$ %.2f%n",
                    origem, destino, valorLiquido);
        }
    }

    // ===== Creators concretos =====
    static class PixCreator extends TransacaoCreator {
        protected Transacao criarTransacao() { return new PixTransacao(); }
    }
    static class BoletoCreator extends TransacaoCreator {
        protected Transacao criarTransacao() { return new BoletoTransacao(); }
    }
    static class TedCreator extends TransacaoCreator {
        protected Transacao criarTransacao() { return new TedTransacao(); }
    }

    // ===== Value Object de saída =====
    static final class Recibo {
        final String id;
        final String tipo;
        final BigDecimal valorBruto;
        final BigDecimal taxa;
        final BigDecimal valorLiquido;
        final String origem;
        final String destino;
        final Instant quando;

        Recibo(String id, String tipo, BigDecimal valorBruto, BigDecimal taxa, BigDecimal valorLiquido,
               String origem, String destino, Instant quando) {
            this.id = id; this.tipo = tipo; this.valorBruto = valorBruto; this.taxa = taxa;
            this.valorLiquido = valorLiquido; this.origem = origem; this.destino = destino; this.quando = quando;
        }

        @Override public String toString() {
            return "Recibo{" +
                    "id='" + id + '\'' +
                    ", tipo='" + tipo + '\'' +
                    ", valorBruto=" + valorBruto +
                    ", taxa=" + taxa +
                    ", valorLiquido=" + valorLiquido +
                    ", origem='" + origem + '\'' +
                    ", destino='" + destino + '\'' +
                    ", quando=" + quando +
                    '}';
        }
    }

    // ===== Demo =====
    public static void main(String[] args) {
        TransacaoCreator pix = new PixCreator();
        TransacaoCreator boleto = new BoletoCreator();
        TransacaoCreator ted = new TedCreator();

        Recibo r1 = pix.processarTransacao(new BigDecimal("100.00"), "Magali", "Cebolinha");
        System.out.println(r1 + "\n---");

        Recibo r2 = boleto.processarTransacao(new BigDecimal("150.00"), "Mônica", "Loja do Limoeiro");
        System.out.println(r2 + "\n---");

        Recibo r3 = ted.processarTransacao(new BigDecimal("500.00"), "Cascão", "Franjinha");
        System.out.println(r3);
    }
}