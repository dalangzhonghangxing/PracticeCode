package leetcode;

public class RangeSumQueryImmutable_303 {
    int[] sums;

    public RangeSumQueryImmutable_303(int[] nums) {
        sums = new int[nums.length];
        if(nums.length == 0) return;
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            sums[i] = sums[i - 1] + nums[i];
    }

    public int sumRange(int i, int j) {
        if(sums.length == 0) return 0;
        if(i == 0)
            return sums[j];
        else
            return sums[j]-sums[i-1];
    }

    public static void main(String[] args) {
        int[] nums = {};
        RangeSumQueryImmutable_303 a = new RangeSumQueryImmutable_303(nums);
        System.out.println(a.sumRange(0, 1));
    }
}

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj =
 * new NumArray(nums); int param_1 = obj.sumRange(i,j);
 */