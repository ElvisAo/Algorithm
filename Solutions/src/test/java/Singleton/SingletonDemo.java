package Singleton;

public class SingletonDemo {
    public static void main(String[] args) {

    }
}

class Singleton_1 {
    private static volatile Singleton_1 instance;

    private Singleton_1() {
    }

    public static Singleton_1 getInstance() {
        if (instance == null) {
            synchronized (Singleton_1.class) {
                if (instance == null) {
                    instance = new Singleton_1();
                }
            }
        }
        return instance;
    }
}

class Singleton_2 {
    private Singleton_2() {
    }

    private static class SingletonInstance {
        private static final Singleton_2 instance = new Singleton_2();
    }

    public static Singleton_2 getInstance() {
        return SingletonInstance.instance;
    }
}
