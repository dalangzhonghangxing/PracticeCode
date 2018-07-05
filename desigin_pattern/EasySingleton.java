package desigin_pattern;

public enum EasySingleton {
    INSTANCE;
    public static int c1;
    public static int c2 = 0;

    static {
        System.out.println(c1);
        System.out.println(c2);
        c1++;
        c2++;
    }

    public void doSomething() {
        System.out.println(c1);
        System.out.println(c2);
    }

}
