package leetcode;

public class Reverse_Integer {
    public int reverse(int x) {
        boolean isNegative = false;
        if (x < 0) isNegative = true;
        String number = String.valueOf(Math.abs(x));
        if (isNegative)
            return 0 - Integer.valueOf(rev(number));
        else
            return Long.valueOf(rev(number)).intValue();
    }

    private String rev(String str) {
        int i = 0, j = str.length() - 1;
        char[] s = str.toCharArray();
        char t;
        while (i < j) {
            t = s[i];
            s[i] = s[j];
            s[j] = t;
            i++;
            j--;
        }
        return String.valueOf(s);
    }

    public static void main(String[] args) {
    }
}
