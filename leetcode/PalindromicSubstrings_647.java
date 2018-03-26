package leetcode;

public class PalindromicSubstrings_647 {

    public int countSubstrings(String s) {
        int ans = cs(s);
        return ans;
    }

    public int cs(String s) {
        int ans[][] = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            ans[i][i] = 1;
            if (i + 1 < s.length()) {
                if (s.charAt(i) == s.charAt(i + 1))
                    ans[i][i + 1] = 3;
                else
                    ans[i][i + 1] = 2;
            }
        }
        for (int i = 2; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                ans[j][j+i] = ans[j][j+i - 1] + ans[j+1][j+i] - ans[j+1][j+i - 1]
                        + isPalindromic(s.substring(j, j+i + 1));
            }
        }
        return ans[0][s.length() - 1];
    }

    public int isPalindromic(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromicSubstrings_647()
                .countSubstrings("xkjkqlajprjwefilxgpdpebieswu"));
    }
}
