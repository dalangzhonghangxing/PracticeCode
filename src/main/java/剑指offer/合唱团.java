package 剑指offer;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.out;

public class 合唱团 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, K, D;
        n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        K = sc.nextInt();
        D = sc.nextInt();

        long[][] dpmax = new long[K][n];
        long[][] dpmin = new long[K][n];

        long ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dpmax[0][i] = a[i];
            dpmin[0][i] = a[i];
            for (int k = 1; k < K; k++)//从第二个人开始考虑
                for (int j = i - 1; j >= 0 && i - j <= D; j--) {//遍历D区间内的每一个人
                    dpmax[k][i] = Math.max(dpmax[k][i], Math.max(dpmax[k - 1][j] * a[i], dpmin[k - 1][j] * a[i]));
                    dpmin[k][i] = Math.min(dpmin[k][i], Math.min(dpmax[k - 1][j] * a[i], dpmin[k - 1][j] * a[i]));
                }
            //如果没有选满K个人，那ans为0
            ans = Math.max(ans, dpmax[K - 1][i]);
        }

        out.println(ans);
    }
}
