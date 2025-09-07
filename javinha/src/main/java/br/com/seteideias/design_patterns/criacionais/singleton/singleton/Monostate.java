package br.com.seteideias.design_patterns.criacionais.singleton.singleton;

// Monostate.java
// Padrão Monostate: várias instâncias, um único estado (estático) compartilhado.
// Tema: Vila do Chaves — "configurações do pátio" visíveis a todos.

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Monostate {

    // "Parece" um objeto normal, mas todo o estado é static.
    public static class VilaConfig {
        // Exemplo de campo simples com visibilidade entre threads
        private static volatile String donoDoBarril = "Chaves";

        // Estado compartilhado mais complexo
        private static final ConcurrentHashMap<String, String> flags = new ConcurrentHashMap<>();

        // Construtor público: podemos instanciar quantas vezes quisermos
        public VilaConfig() { }

        // API de instância (mas altera/lê estado ESTÁTICO)
        public void setDonoDoBarril(String nome) {
            donoDoBarril = nome; // volatile garante visibilidade
        }

        public String getDonoDoBarril() {
            return donoDoBarril;
        }

        public void setFlag(String key, String value) {
            flags.put(key, value); // thread-safe
        }

        public String getFlag(String key) {
            return flags.get(key);
        }

        public Map<String, String> snapshot() {
            return Map.copyOf(flags);
        }

        // Útil pra testes: "limpa" o estado global
        public static void resetForTests() {
            flags.clear();
            donoDoBarril = "Chaves";
        }
    }

    public static void main(String[] args) {
        VilaConfig a = new VilaConfig();
        VilaConfig b = new VilaConfig();

        System.out.println("a == b ? " + (a == b)); // false: instâncias diferentes

        // Compartilhamento do estado:
        System.out.println("dono (antes) a/b: " + a.getDonoDoBarril() + " / " + b.getDonoDoBarril());
        a.setDonoDoBarril("Seu Madruga");
        System.out.println("dono (depois) a/b: " + a.getDonoDoBarril() + " / " + b.getDonoDoBarril());

        b.setFlag("cobranca", "Sr. Barriga");
        System.out.println("flag em a: cobranca=" + a.getFlag("cobranca")); // visível em ambas
    }

}
