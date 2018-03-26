package leetcode;

public class MajorityElement_169 {
    public int majorityElement(int[] nums) {
        int count = 1;
        int current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(current == nums[i])
                count ++;
            else{
                count --;
                if(count <=0){
                    count = 1;
                    current = nums[i];
                }
                    
            }
        }
        return current;
    }
}
