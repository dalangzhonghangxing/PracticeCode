package leetcode;

public class ExcelSheetColumnNumber_171 {
    public int titleToNumber(String s) {
        int ans = 0;
        int k = 26;
        for (int i = s.length() - 1; i >= 0; i--) {
            ans += (s.charAt(i) - 'A' + 1) * ((int)Math.pow(k, s.length() - i - 1));
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnNumber_171().titleToNumber("AAB"));
    }
}
