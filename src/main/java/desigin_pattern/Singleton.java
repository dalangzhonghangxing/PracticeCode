package desigin_pattern;

public class Singleton {
    static {
        System.out.println("Singleton static");
    }

    private static class SingletonHolder {
        static {
            System.out.println("SingletonHolder static");
        }
        private static final Singleton instance = new Singleton();
    }

    private Singleton() {
        System.out.println("Singleton construct");
    }

    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }
}
