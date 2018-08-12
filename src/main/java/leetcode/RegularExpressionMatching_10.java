package leetcode;

public class RegularExpressionMatching_10 {

    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        boolean isHeadMatch = (!s.isEmpty() && (s.charAt(0) == p.charAt(0)
                || (p.charAt(0) == '.')));
        if(p.length()>1 && p.charAt(1) == '*'){
            return (isMatch(s,p.substring(2)) || (isHeadMatch && isMatch(s.substring(1), p)));
        }else{
            return (isHeadMatch && isMatch(s.substring(1), p.substring(1)));
        }

    }

    public static void main(String[] args) {
        System.out
                .println(new RegularExpressionMatching_10().isMatch("aab", "c*ab"));
    }
}
