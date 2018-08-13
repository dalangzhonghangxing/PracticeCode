package 剑指offer;

import static java.lang.System.out;

public class 数组中只出现一次的数字 {
    public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        for (int a : array)
            num1[0] ^= a;

        // 找到num1[0]中右边第一个不为0的位
        int p = 1;
        while ((num1[0] & p) == 0) {
            p = p << 1;
        }

        num1[0] = 0;
        for (int a : array) {
            if ((a & p) == 0) {
                num1[0] ^= a;
            } else {
                num2[0] ^= a;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {2,4,3,6,3,2,5,5}, a1 = new int[1], a2 = new int[1];
        FindNumsAppearOnce(array, a1, a2);
        out.println(a1);
    }
}
