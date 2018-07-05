package key_package;

public class K75SortColors {
    public void sortColors(int[] nums) {

        int zp = 0, tp = nums.length - 1, t;
        while (zp < tp) { // 先把0 放好
            while (zp < tp && nums[zp] == 0)
                zp++;
            while (zp < tp && nums[tp] != 0)
                tp--;
            t = nums[zp];
            nums[zp] = nums[tp];
            nums[tp] = t;
        }

        tp = nums.length - 1;
        if (nums[zp] == 0) zp++;
        while (zp < tp) { // 把1 放好
            while (zp < tp && nums[zp] == 1)
                zp++;
            while (zp < tp && nums[tp] != 1)
                tp--;
            t = nums[zp];
            nums[zp] = nums[tp];
            nums[tp] = t;
        }
    }
}
