package br.com.seteideias.design_patterns.criacionais.singleton.singleton;

public class SimpleSingleton {
    public static final class ConnectionPool {
        private static final ConnectionPool INSTANCE = new ConnectionPool(); // final
        private ConnectionPool() {
            System.out.println("um unico criado");
        }
        public static ConnectionPool getInstance() {
            return INSTANCE;
        }
    }

    public static void main(String[] args) {
        ConnectionPool pool1 = ConnectionPool.getInstance();
        ConnectionPool pool2 = ConnectionPool.getInstance();
        System.out.println(pool1 == pool2);
    }
}


