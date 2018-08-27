package 剑指offer;

import java.util.Scanner;

import static java.lang.System.out;

public class 丰收 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, a[], m;
        n = sc.nextInt();
        a = new int[n];
        a[0] = sc.nextInt();
        for (int i = 1; i < n; i++)
            a[i] = a[i - 1] + sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < m; i++)
            out.println(getAns(a, sc.nextInt()));
    }

    public static int getAns(int[] a, int q) {
        if (a[0] >= q)
            return 1;
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (a[m] == q) {
                return m + 1;
            } else if (a[m] > q) {
                if (a[m - 1] < q)
                    return m + 1;
                r = m - 1;
            } else if (a[m] < q) {
                l = m + 1;
            }
        }
        return l;
    }
}
