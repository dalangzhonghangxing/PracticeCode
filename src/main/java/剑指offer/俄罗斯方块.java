package 剑指offer;

import java.util.Scanner;

import static java.lang.System.out;

public class 俄罗斯方块 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        int col[] = new int[n];
        int a;
        for (int i = 0; i < m; i++) {
            a = sc.nextInt();
            col[a - 1]++;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
            ans = Math.min(ans, col[i]);
        out.println(ans);
    }
}
