package 剑指offer;

import static java.lang.System.out;

public class 数字在排序数组中出现的次数 {
    public static int GetNumberOfK(int[] array, int k) {
        int leftNumberPos = getLeftPos(array, k);
        int rightNumberPos = getRightPos(array, k);
        if (leftNumberPos < 0) return 0;
        return rightNumberPos - leftNumberPos + 1;
    }

    public static int getLeftPos(int[] array, int k) {
        int mid;
        int left = 0, right = array.length - 1;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (array[mid] == k) {
                if (mid == 0 || (mid > 0 && array[mid - 1] != k))
                    return mid;
                else
                    right = mid - 1;
            } else if (array[mid] < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int getRightPos(int[] array, int k) {
        int mid;
        int left = 0, right = array.length - 1;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (array[mid] == k) {
                if (mid == array.length - 1 || (mid < (array.length - 1) && array[mid + 1] != k))
                    return mid;
                else
                    left = mid + 1;
            } else if (array[mid] < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1,1,1,1,1,1};
        out.println(GetNumberOfK(array, 1));

    }
}
