package 剑指offer;

import Reflect.P;

import java.util.ArrayList;

public class 和为S的两个数字 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> ans = new ArrayList<>();
        int left = 0, right = array.length - 1, diff;
        while (left < right) {
            diff = sum - array[left];
            if (diff > array[right]) {
                left++;
            } else if (diff < array[right]) {
                right--;
            } else {
                ans.add(array[left]);
                ans.add(array[right]);
                return ans;
            }
        }
        return ans;
    }
}
