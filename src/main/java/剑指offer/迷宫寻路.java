package 剑指offer;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static java.lang.System.out;

public class 迷宫寻路 {
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        m = sc.nextInt();
        n = sc.nextInt();
        char[][] graph = new char[m][n];
        int[][] vt = new int[m][n];//访问次数，最多允许一个格子走两次
        Set<Integer> keys = new HashSet<>();
        String line;
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            line = sc.nextLine();
            graph[i] = line.toCharArray();
        }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (graph[i][j] == '2')
                    dfs(graph, keys, vt, i, j, 0);
        out.println(ans);
    }

    public static void dfs(char[][] graph, Set<Integer> keys, int[][] vt, int m, int n, int number) {
        char c = graph[m][n];
        if (c == '0')
            return;
        if (c == '3') {
            ans = Math.min(ans, number);
            return;
        }
        if (vt[m][n] >= 2)
            return;
        if (c >= 'A' && c <= 'Z') {//有门
            if (!keys.contains(c - 'A')) //没钥匙
                return;
        }

        if (c >= 'a' && c <= 'z') { // 钥匙
            if (vt[m][n] < 1) //钥匙只能拿一次
                keys.add(c - 'a');
        }
        vt[m][n]++;

        if (m + 1 < graph.length)
            dfs(graph, keys, vt, m + 1, n, number + 1);
        if (n + 1 < graph[0].length)
            dfs(graph, keys, vt, m, n + 1, number + 1);
        if (m - 1 >= 0)
            dfs(graph, keys, vt, m - 1, n, number + 1);
        if (n - 1 >= 0)
            dfs(graph, keys, vt, m, n - 1, number + 1);


        // 回溯
        if (c >= 'a' && c <= 'z')
            keys.remove(c - 'a');
        vt[m][n]--;
    }
}
