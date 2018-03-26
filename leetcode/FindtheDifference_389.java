package leetcode;
import java.util.Arrays;

public class FindtheDifference_389 {
    public char findTheDifference(String s, String t) {
        s = s+t;
        char[] newstring = s.toCharArray();
        Arrays.sort(newstring);
        int count=1;
        for(int i = 0;i<newstring.length-1;i++){
            if(newstring[i] != newstring[i+1])
                if(count%2 ==1) return newstring[i];
                else count =0;
            count ++;
        }
        return newstring[newstring.length-1];
    }
    public static void main(String[] args) {
        System.out.println(new FindtheDifference_389().findTheDifference("abcd", "abcde"));
    }
}
