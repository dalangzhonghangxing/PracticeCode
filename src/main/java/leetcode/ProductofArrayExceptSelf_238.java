package leetcode;

public class ProductofArrayExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        boolean twoZero = false;
        int index = -1;
        if (nums[0] == 0) index = 0;
        for (int i = 1; i < nums.length; i++) {
            ans[0] *= nums[i];
            if (nums[i] == 0) {
                if (index == -1)
                    index = i;
                else
                    twoZero = true;
            }

        }
        if (twoZero) return ans;
        if (index != -1) {
            for (int i = 0; i < nums.length; i++) {
                if (i == index) {
                    ans[i] = 1;
                    for (int j = 0; j < nums.length; j++) {
                        if (j != i) ans[i] *= nums[j];
                    }
                }else
                    ans[i] = 0;
            }
        } else {
            for (int i = 1; i < nums.length; i++) {
                ans[i] = ans[0] * nums[0] / nums[i];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,0};
        for(int i : new ProductofArrayExceptSelf_238().productExceptSelf(nums)){
            System.out.print(i+" ");
        }
    }
}
