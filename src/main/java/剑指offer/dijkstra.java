package 剑指offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.System.out;

public class dijkstra {
    public static void main(String[] args) {
        int N = Integer.MAX_VALUE;
        int[][] Graph = {
                {0, 1, 5, N, N, N, N, N, N},
                {1, 0, 3, 7, 5, N, N, N, N},
                {5, 3, 0, N, 1, 7, N, N, N},
                {N, 7, N, 0, 2, N, 3, N, N},
                {N, 5, 1, 2, 0, 3, 6, 9, N},
                {N, N, 7, N, 3, 0, N, 5, N},
                {N, N, N, 3, 6, N, 0, 2, 7},
                {N, N, N, N, 9, 5, 2, 0, 4},
                {N, N, N, N, N, N, 7, 4, 0}};
        getAns(Graph, 0, 3);
    }

    /**
     * 查找节点u到节点v的最短路径
     */
    public static void getAns(int[][] graph, int u, int v) {
        int parent[] = new int[graph.length];
        int dis[] = new int[graph.length];
        int from[] = new int[graph.length];
        Set<Integer> selectedNode = new HashSet<>();
        int length = graph.length;

        // 初始化dis,from数组
        for (int i = 0; i < length; i++) {
            dis[i] = graph[u][i];
            from[i] = u;
        }
        // 初始化parent数组
        parent[u] = -1;
        selectedNode.add(u);

        if (selectedNode.contains(v)) return;

        // 每次找一个到已选节点集合最近的节点加入
        for (int i = 1; i < length; i++) {
            // 找到下一个要加入的节点
            int k = Integer.MAX_VALUE, index = -1;
            for (int j = 0; j < length; j++) {
                if (selectedNode.contains(j))
                    continue;
                if (k > dis[j]) {
                    k = dis[j];
                    index = j;
                }
            }
            selectedNode.add(index);
            parent[index] = from[index];
            if (index == v)
                break;

            // 更新dis跟from
            for (int j = 0; j < length; j++) {
                if (dis[j] > graph[index][j]) {
                    dis[j] = graph[index][j];
                    from[j] = index;
                }
            }
        }

        int minDis = 0;
        List<Integer> path = new ArrayList<>();
        path.add(v);
        for (int i = parent[v]; i != -1; i = parent[i]) {
            minDis += graph[i][path.get(path.size() - 1)];
            path.add(i);
        }
        for (int i = path.size() - 1; i > 0; i--)
            out.print(path.get(i) + "->");
        out.println(path.get(0));
        out.println(minDis);
    }
}
