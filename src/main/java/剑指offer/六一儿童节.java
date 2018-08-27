package 剑指offer;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.out;

public class 六一儿童节 {
    public static void main(String[] args) {
        int n, m, h[], w[];
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        h = new int[n];
        for (int i = 0; i < n; i++)
            h[i] = sc.nextInt();
        m = sc.nextInt();
        w = new int[m];
        for (int i = 0; i < m; i++)
            w[i] = sc.nextInt();
        Arrays.sort(h);
        Arrays.sort(w);
        int hi = 0, wi = 0, ans = 0;
        while (hi < n && wi < m) {
            if (w[wi] < h[hi]) {
                wi++;
                continue;
            }
            ans++;
            wi++;
            hi++;
        }

        out.println(ans);
    }
}
