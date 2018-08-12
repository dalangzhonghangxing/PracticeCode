package leetcode;
public class ArithmeticSlices_413 {
    public int numberOfArithmeticSlices(int[] A) {
        int ans = 0;
        boolean[][] dp = new boolean[A.length][A.length];
        for (int step = 0; step < 2; step++)
            for (int i = 0; i + step < A.length; i++) {
                dp[i][i + step] = true;
            }

        for (int step = 2; step < A.length; step++) {
            for (int i = 0; i + step < A.length; i++) {
                if (dp[i][i + step - 1] && A[i + step - 1]
                        - A[i + step - 2] == A[i + step] - A[i + step - 1]) {
                    dp[i][i + step] = true;
                    ans++;
                } else {
                    dp[i][i + step] = false;
                }
            }
        }
        return ans;
    }
}
