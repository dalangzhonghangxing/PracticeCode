package 剑指offer;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * 给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，要求时间复杂度：O(n)，空间复杂度：O(1)
 * 找出2个最小的负数，3个最大的负数，3个最大的正数，比较他们的乘积大小
 */
public class 最大乘积 {
    public static void main(String[] args) {
        long fn[] = new long[2], fm[] = new long[3], z[] = new long[3], fc = 0, zc = 0;
        boolean zero = false;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long a;
        for (int i = 0; i < n; i++) {
            a = sc.nextInt();
            long t;
            if (a < 0) {
                for (int j = 0; j < 2; j++) {//找出最小的两个负数
                    if (a < fn[j]) {
                        t = fn[j];
                        fn[j] = a;
                        a = t;
                    }
                }
                for (int j = 0; j < 3; j++) {//找出最大的3个负数
                    if (a > fm[j]) {
                        t = fm[j];
                        fm[j] = a;
                        a = t;
                    }
                }
                fc++;
            } else if (a > 0) {
                for (int j = 0; j < 3; j++) {//找出最大的3个正数
                    if (a > z[j]) {
                        t = z[j];
                        z[j] = a;
                        a = t;
                    }
                }
                zc++;
            } else
                zero = true;
        }
        long zz = Long.MIN_VALUE, fz;
        if (zc >= 3)
            zz = z[0] * z[1] * z[2];
        if (fc >= 2 && zc >= 1)
            fz = fn[0] * fn[1] * max(z);
        else
            fz = fm[0] * fm[1] * fm[2];
        long ans = Math.max(zz, fz);
        if (ans > 0)
            out.println(ans);
        else if (zero)
            out.println(0);
        else
            out.println(ans);
    }

    public static long max(long[] z) {
        long res = 0;
        for (int i = 0; i < z.length; i++)
            if (res < z[i])
                res = z[i];
        return res;
    }
}
