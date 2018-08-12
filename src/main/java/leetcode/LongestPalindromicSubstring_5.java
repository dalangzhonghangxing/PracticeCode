package leetcode;

public class LongestPalindromicSubstring_5 {
    public String longestPalindrome(String s) {
        int ansLen = 0;
        String ans = s;
        for (int i = 0; i < s.length() - 1; i++) {
            String sb1 = getLengthOfPalindrome(s, i, i);
            String sb2 = getLengthOfPalindrome(s, i, i + 1);
            int maxLen = Math.max(sb1.length(), sb2.length());
            if (ansLen < maxLen) {
                ansLen = maxLen;
                if (sb1.length() == maxLen) {
                    ans = sb1;
                } else
                    ans = sb2;
            }
            if (maxLen/2 > s.length() -i) break;
        }
        return ans;
    }

    private String getLengthOfPalindrome(String s, int ci, int cj) {
        if (s.charAt(ci) != s.charAt(cj)) return "";
        int left = ci - 1, right = cj + 1;
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring_5()
                .longestPalindrome("ababababa"));
    }
}
