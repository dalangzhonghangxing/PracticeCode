package key_package;

public class K153FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, mid;
        if (nums[left] < nums[right]) return nums[left];
        while (left < right) {
            if (right - left == 1) { return Math.min(nums[left], nums[right]); }
            mid = (left + right) / 2;
            if (nums[mid] > nums[left]) {
                left = mid;
            } else if (nums[mid] < nums[left]) {
                right = mid;
            }
        }
        return nums[right];
    }

    public static void main(String[] args) {
        int[] nums = { 5, 1, 2, 3, 4 };
        System.out.println(
                new K153FindMinimuminRotatedSortedArray().findMin(nums));
    }

}
