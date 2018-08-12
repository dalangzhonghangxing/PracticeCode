package leetcode;

public class ZigZagConversion_6 {
    public String convert(String s, int numRows) {
        StringBuffer ans = new StringBuffer();
        int a = s.length() / (1 + numRows);
        int y = s.length() % (1 + numRows);

        for (int j = 0; j < numRows; j++) {
            if (j == (numRows - 1) / 2)
                for (int i = j; i < s.length(); i += (1 + numRows) / 2) {
                    ans.append(s.charAt(i));
                }
            else
                for (int i = j; i < s.length(); i += 1 + numRows) {
                    ans.append(s.charAt(i));
                }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ZigZagConversion_6().convert("A", 1));
    }
}
