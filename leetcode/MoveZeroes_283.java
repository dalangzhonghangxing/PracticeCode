package leetcode;
public class MoveZeroes_283 {
    public void moveZeroes(int[] nums) {
        int t = 0, i;
        for (i = 0; i < nums.length; i++)
            if (nums[i] != 0) nums[t++] = nums[i];
        for (; t < nums.length; t++)
            nums[t] = 0;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 3, 12 };
        new MoveZeroes_283().moveZeroes(nums);
    }
}
