package leetcode;

public class huiwenshu {

    public void printHWS(String str) {
        boolean dp[][] = new boolean[str.length()][str.length()];
        for (int i = 0; i < str.length(); i++)
            dp[i][i] = true;
        for (int step = 1; step < str.length(); step++)
            for (int j = 0; j + step < str.length(); j++) {
                if (step == 1)
                    dp[j][j + step] = str.charAt(j) == str.charAt(j + step);
                else
                    dp[j][j + step] = str.charAt(j) == str.charAt(j + step)
                            && dp[j + 1][j + step - 1];
                if (step >= 7 && dp[j][j + step])
                    System.out.println(str.substring(j, j + step + 1));
            }
    }

    public static void main(String[] args) {
       new huiwenshu().printHWS("babaaaaaaaaabab");
    }
}
