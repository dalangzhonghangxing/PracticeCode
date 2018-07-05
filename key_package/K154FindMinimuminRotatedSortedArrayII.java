package key_package;

public class K154FindMinimuminRotatedSortedArrayII {
    private int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        return findMin(nums, left, right);
    }

    private int findMin(int[] nums, int left, int right) {
        // 从左到右是有序的
        if (nums[left] < nums[right]) return nums[left];

        // 最小值在右边
        int mid;
        while (left < right) {
            if (right - left == 1) return Math.min(nums[left], nums[right]);

            mid = (left + right) / 2;
            if (nums[mid] > nums[left]) {// 左半部分递增
                left = mid;
            } else if (nums[mid] < nums[left]) { // 最小值坑能是mid或在左边
                right = mid;
            } else {
                if (nums[mid] > nums[right]) {
                    left = mid;
                } else if (nums[mid] == nums[right]) {
                    int leftMin = findMin(nums, left + 1, mid - 1);
                    int rightMin = findMin(nums, mid + 1, right - 1);
                    return Math.min(leftMin, rightMin);
                }
            }
        }
        return nums[right];
    }

    public static void main(String[] args) {
        int[] nums = { 1,3,1,1};
        System.out.println(
                new K154FindMinimuminRotatedSortedArrayII().findMin(nums));
    }
}
