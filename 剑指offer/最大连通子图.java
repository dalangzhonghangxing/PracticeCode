/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package 剑指offer;

/**
 * 1。 使用一个公共的flag数组来标记每个位置是否被访问过。
 * 2。 for循环遍历每个节点，以它们为根开始深度遍历，如果根节点访问过，则不遍历。
 * 3。 每次遍历极为一个连通子图，计算其连通个数。
 */
public class 最大连通子图 {

    public int getMaxSubGraph(int[][] graph) {
        boolean flag[][] = new boolean[graph.length][graph[0].length];
        int max = 0;
        for (int x = 0; x < graph.length; x++) {
            for (int y = 0; y < graph[x].length; y++) {
                if (flag[x][y]) continue;
                int size = dfs(graph, flag, x, y, 0);
                if (size > max) max = size;
            }
        }
        return max;

    }

    public int dfs(int[][] graph, boolean[][] flag, int x, int y, int size) {
        int type = graph[x][y];//记录当前块的类型
        size += 1;
        flag[x][y] = true;

        // dfs只往同类型的块中递归
        // 向上走
        if (x - 1 >= 0 && !flag[x - 1][y] && graph[x - 1][y] == type) {
            size = dfs(graph, flag, x - 1, y, size);
        }
        // 向下走
        if (x + 1 < graph.length && !flag[x + 1][y] && graph[x + 1][y] == type) {
            size = dfs(graph, flag, x + 1, y, size);
        }
        // 向左走
        if (y - 1 >= 0 && !flag[x][y - 1] && graph[x][y - 1] == type) {
            size = dfs(graph, flag, x, y - 1, size);
        }
        // 向右走
        if (y + 1 < graph[x].length && !flag[x][y + 1] && graph[x][y + 1] == type) {
            size = dfs(graph, flag, x, y + 1, size);
        }
        return size;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {2, 1, 1, 2, 1, 2},
                {1, 2, 2, 1, 2, 2},
                {1, 2, 2, 1, 1, 2},
                {1, 1, 2, 1, 1, 2}
        };
        System.out.println(new 最大连通子图().getMaxSubGraph(graph));
    }
}
