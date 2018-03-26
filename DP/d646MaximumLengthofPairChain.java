package DP;

import java.util.Arrays;

public class d646MaximumLengthofPairChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        if (pairs == null || pairs.length == 0) return 0;
        
        int dp[] = new int[pairs.length];
        dp[0] = 1;
        int max, res = 1;
        for (int i = 1; i < pairs.length; i++) {
            max = 1;
            for (int j = 0; j < i; j++) {
                if (pairs[i][1] < pairs[j][0]) max = Math.max(max, dp[j] + 1);
            }
            dp[i] = max;
            if (res < max) res = max;
        }
        return res;
    }
}
