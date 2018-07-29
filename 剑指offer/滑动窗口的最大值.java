package 剑指offer;

import java.util.ArrayList;

/**
 * 1. 找到当前窗口的最大值以及对应的index
 * 2. 当窗口滑动时，如果最大元素被移除，那重新找最大子以及对应的index
 * 3. 当窗口滑动时，如果最大元素没有被移除，比较新元素与最大值并更新
 */
public class 滑动窗口的最大值 {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (size == 0) return res;
        int[] maxAndIndex = getMaxAndIndex(num, 0, size - 1);
        int max = maxAndIndex[0], index = maxAndIndex[1];
        res.add(max);
        for (int i = 1; i < num.length - size + 1; i++) {
            if (index < i) {//原来的最大值被淘汰
                maxAndIndex = getMaxAndIndex(num, i, i + size - 1);
                res.add(maxAndIndex[0]);
                index = maxAndIndex[1];
                max = maxAndIndex[0];
            } else {
                if (num[i + size - 1] > max) {
                    max = num[i + size - 1];
                    index = i + size - 1;
                }
                res.add(max);
            }
        }
        return res;
    }

    public int[] getMaxAndIndex(int[] num, int left, int right) {
        int[] res = new int[2];
        res[0] = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++)
            if (res[0] < num[i]) {
                res[0] = num[i];
                res[1] = i;
            }
        return res;
    }

    public static void main(String[] args) {
        int[] num = {1, 3, -1, -3, 5, 3, 6, 7};
        int size = 3;
        System.out.println(new 滑动窗口的最大值().maxInWindows(num, size));
    }

}
