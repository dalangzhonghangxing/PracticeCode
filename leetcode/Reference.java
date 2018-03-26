package leetcode;

public class Reference {
    public Reference instance;
    
    public static void main(String[] args) {
        Reference a = new Reference();
        Reference b = new Reference();
        a.instance = b;
        b.instance = a;
        
        a = null;
        b = null;
    }
}
