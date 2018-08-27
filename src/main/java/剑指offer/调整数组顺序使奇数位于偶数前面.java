package 剑指offer;

import java.util.Arrays;

/**
 * 借助额外空间，时间复杂度O(N)，空间复杂度O(N)。不借助额外空间，时间复杂度O(N^2)。
 */
public class 调整数组顺序使奇数位于偶数前面 {
    public void reOrderArray(int[] array) {
        if (array == null || array.length == 0) return;
        int a[] = Arrays.copyOf(array,array.length), index = 0;
        for (int i = 0; i < a.length; i++)
            if ((a[i] & 1) == 1)
                array[index++] = a[i];
        for (int i = 0; i < a.length; i++)
            if ((a[i] & 1) == 0)
                array[index++] = a[i];
    }
}
