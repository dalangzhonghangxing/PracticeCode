package leetcode;

public class ReverseString_344 {
    public String reverseString(String s) {
        StringBuffer res = new StringBuffer();
        for(int i=s.length()-1;i>=0;i--){
            res.append(s.charAt(i));
        }
        return res.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new ReverseString_344().reverseString("hello")); 
    }
}
