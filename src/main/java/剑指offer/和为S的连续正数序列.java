package 剑指offer;

import java.util.ArrayList;

public class 和为S的连续正数序列 {
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (sum == 1 || sum == 2) {
            return ans;
        }
        int left = 1, right = 2, s = 3, max = (sum + 1) >> 1;
        while (right <= max) {
            if (s == sum) {
                ArrayList<Integer> one = new ArrayList<>();
                for (int i = left; i <= right; i++)
                    one.add(i);
                ans.add(one);
                s -= left;
                left++;
                right++;
                s += right;
            } else if (s < sum) {
                right++;
                s += right;
            } else {
                s -= left;
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindContinuousSequence(100);
    }
}
