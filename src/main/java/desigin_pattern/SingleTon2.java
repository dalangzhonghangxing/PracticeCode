package desigin_pattern;

public class SingleTon2 {
    
    public static int c1;
    public static int c2 = 0;
    
    private static SingleTon2 singleTon = new SingleTon2();
 
    private SingleTon2() {
        System.out.println(c1);
        System.out.println(c1);
        c1++;
        c2++;
    }
 
    public static SingleTon2 getInstance() {
        return singleTon;
    }
}
 
