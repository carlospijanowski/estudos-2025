package br.com.seteideias.design_patterns.criacionais.singleton.singleton;

// Singleton.java
// Singleton thread-safe e lazy usando o "Initialization-on-Demand Holder".
// Tema: Vila do Chaves — centraliza "configs do pátio".

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public final class Singleton {

    // "Configurações do pátio" (ex.: dono do barril, cobrador do aluguel...)
    private final Map<String, String> flags = new ConcurrentHashMap<>();

    // Construtor privado: ninguém instancia por fora
    private Singleton() {
        flags.put("donoDoBarril", "Chaves");
        flags.put("cobranca", "Sr. Barriga");
    }

    // Holder garante carregamento preguiçoso e segurança de threads
    private static class Holder {
        private static final Singleton INSTANCE = new Singleton();
    }

    // Ponto único de acesso
    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }

    // API simples de leitura/escrita
    public void setFlag(String key, String value) {
        flags.put(key, value);
    }

    public String getFlag(String key) {
        return flags.get(key);
    }

    public Map<String, String> snapshot() {
        return Map.copyOf(flags);
    }

    // Demonstração rápida
    public static void main(String[] args) {

        System.out.println(Singleton.getInstance());

        Singleton cfg1 = Singleton.getInstance();
        cfg1.setFlag("fiadorDoAluguel", "Seu Madruga");

        Singleton cfg2 = Singleton.getInstance();
        System.out.println(cfg1 == cfg2 ? "Uma instância só (ok!)" : "Ops, várias instâncias!");
        System.out.println("donoDoBarril = " + cfg2.getFlag("donoDoBarril"));
        System.out.println("fiadorDoAluguel = " + cfg2.getFlag("fiadorDoAluguel"));
    }
}
