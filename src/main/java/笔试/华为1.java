package 笔试;

public class 华为1 {
    public static void main(String[] args) {
        int values[] = { 6, 3, 5, 4, 6 };
        int weights[] = { 2, 6, 6, 5, 4 };
        int total = 10;
        int dp[][] = new int[values.length + 1][total + 1];

        for (int i = 0; i < values.length; i++) {
            for (int j = 1; j <= total; j++) {
                if (j - weights[i] >= 0)
                    dp[i + 1][j] = Math.max(dp[i][j - weights[i]] + values[i],
                            dp[i][j]);
                else
                    dp[i + 1][j] = dp[i][j];
            }
        }
        System.out.println(dp[values.length][total]);
    }
}
