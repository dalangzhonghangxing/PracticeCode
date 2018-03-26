package leetcode;
import java.util.Arrays;

public class SingleNumber_136 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i+=2){
            if(nums[i] != nums[i++])
                return nums[i];
        }
        return -1;
    }
}
