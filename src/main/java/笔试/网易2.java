package 笔试;

import java.util.Scanner;

public class 网易2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] h = new int[n];
        int a = 0;
        for (int i = 0; i < n; i++) {
            a += sc.nextInt();
            h[i] = a;
        }
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int k = sc.nextInt();
            System.out.println(1 + getAns(h, k));
        }
    }

    private static int getAns(int[] h, int val) {
        int l = 0;
        int r = h.length - 1;
        int m = (l + r + 1) / 2;
        while (l < r) {
            if (h[m] == val) {
                return m;
            } else if (h[m] > val) {
                r = m - 1;
            } else {
                l = m;
            }
            m = (l + r + 1) >> 1;
        }
        if (h[l] < val) {
            return l + 1;
        }
        return l;
    }
}
