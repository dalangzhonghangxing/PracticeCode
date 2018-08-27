package 剑指offer;

import java.util.Scanner;

import static java.lang.System.out;

public class 瞌睡 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, k, hasGetScore = 0;
        n = sc.nextInt();
        k = sc.nextInt();
        int[] a = new int[n], t = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
            if (t[i] == 1) {
                hasGetScore += a[i];
                a[i] = 0;
            }
        }

        int maxWeak = 0, cWeak = 0;
        for (int i = 0; i < k; i++)
            maxWeak += a[i];
        cWeak = maxWeak;
        for (int i = k; i < n; i++) {
            cWeak = cWeak - a[i - k] + a[i];
            maxWeak = Math.max(maxWeak, cWeak);
        }
        out.println(maxWeak + hasGetScore);
    }
}
