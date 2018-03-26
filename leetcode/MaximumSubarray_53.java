package leetcode;
public class MaximumSubarray_53 {
    public int maxSubArray(int[] nums) {
        if (nums.length <= 1) return 0;
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }
    public static void main(String[] args) {
        int[] a = {1};
        new MaximumSubarray_53().maxSubArray(a);
    }
}
