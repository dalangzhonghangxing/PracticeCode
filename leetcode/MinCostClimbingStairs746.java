package leetcode;

public class MinCostClimbingStairs746 {
    public int minCostClimbingStairs(int[] cost) {
        int costed[] = new int[cost.length];
        for (int c : costed)
            c = 0;
        costed[0] = cost[0];
        costed[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            costed[i] = Math.min(costed[i - 1], costed[i - 2]) + cost[i];
        }
        return Math.min(costed[cost.length - 1], costed[cost.length - 2]);
    }
}
