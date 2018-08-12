package key_package;

import java.util.HashSet;
import java.util.Set;

public class K220ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k == 0) return false;
        Set<Long> resentK = new HashSet<>();
        int min = nums[0], max = nums[0];
        resentK.add((long) nums[0]);
        for (int i = 1; i < nums.length; i++) {
            for (long j = Math.max( min, (long)nums[i] - t); j <= Math
                    .min((long) nums[i] + t, max); j++)
                if (resentK.contains(j)) return true;
            resentK.add((long) nums[i]);
            if (resentK.size() > k) resentK.remove((long) nums[i - k]);
            if (nums[i] < min)
                min = nums[i];
            else if (nums[i] > max) max = nums[i];
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = { -2147483648, -2147483647 };
        int k = 3, t = 3;
        System.out.println(new K220ContainsDuplicateIII().containsNearbyAlmostDuplicate(nums, k,
                t));
    }
}
