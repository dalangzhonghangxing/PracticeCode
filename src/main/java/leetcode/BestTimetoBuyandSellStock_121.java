package leetcode;

public class BestTimetoBuyandSellStock_121 {
    public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        int dp[] = new int[prices.length];
        int min = prices[0];
        dp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - min < 0) {
                min = prices[i];
                dp[i] = dp[i - 1];
            } else {
                dp[i] = Math.max(prices[i] - min, dp[i - 1]);
            }
        }
        return dp[prices.length - 1];
    }

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        new BestTimetoBuyandSellStock_121().maxProfit(prices);
    }
}
