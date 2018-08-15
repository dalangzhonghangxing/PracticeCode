package 剑指offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.System.out;

/**
 * 1. 计算所有节点的出度
 * 2. 删除出度为0的节点
 * 3. 重复上述过程，直到没有节点能删除
 * 4. 如果还有节点，则有环；否则，没环。
 */
public class 判断图是否有环 {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}
        };
        out.println(isCircle(graph));
    }

    public static boolean isCircle(int[][] graph) {
        int n = graph.length;
        Set<Integer> deletedNodes = new HashSet<>();
        List<Integer> toDelete = new ArrayList<>();
        while (true) {
            deletedNodes.addAll(toDelete);
            toDelete.clear();
            for (int i = 0; i < n; i++) {
                int cd = 0;
                for (int j = 0; j < n; j++) {
                    cd += graph[i][j];
                }
                if (cd == 0 && !deletedNodes.contains(i))//如果入度是1，则加入toDelete列表
                    toDelete.add(i);
            }
            if (toDelete.size() == 0) // 如果没有入度是1的节点，就跳出
                break;
            for (int index : toDelete) {
                for (int j = 0; j < n; j++) {
                    graph[index][j] = 0;
                    graph[j][index] = 0;
                }
            }
        }
        if (deletedNodes.size() == n)//如果全删除，说明没有环
            return false;
        return true;
    }
}
