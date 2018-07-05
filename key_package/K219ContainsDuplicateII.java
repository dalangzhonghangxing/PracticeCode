package key_package;

import java.util.HashSet;
import java.util.Set;

/**
 * 用集合优化，当集合长度大于k，移除集合中最前面的数
 **/
public class K219ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2) return false;
        Set<Integer> resentK = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (resentK.contains(i)) return true;
            resentK.add(nums[i]);
            if (resentK.size() > k) resentK.remove(nums[i - k]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = { -1, -1 };
        int k = 1;
        new K219ContainsDuplicateII().containsNearbyDuplicate(nums, k);
    }
}
