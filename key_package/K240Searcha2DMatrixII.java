package key_package;

public class K240Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] > target) return false;
            int col = binarySearchInRow(matrix[i], 0, matrix[i].length - 1,
                    target);
            if (col != -1) return true;
        }
        return false;
    }

    private int binarySearchInRow(int[] nums, int left, int right, int k) {
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] > k) {
                right = mid - 1;
            } else if (nums[mid] < k) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 } };
        int target = 5;
        System.out.println(
                new K240Searcha2DMatrixII().searchMatrix(matrix, target));
    }
}
