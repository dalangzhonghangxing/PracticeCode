package DP;

public class d300LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int dp[] = new int[nums.length];
        dp[0] = 1;
        int max;
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] >= nums[j]) {
                    max = Math.max(dp[j] + 1, max);
                }
            }
            dp[i] = max;
            if (max > ans) ans = max;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new d300LongestIncreasingSubsequence().lengthOfLIS(nums));
    }
}
