package leetcode;
import java.util.Scanner;

public class forMirosoft {

    private static int N, M, K;
    private static int[] A, leaves, parents;
    private static int[][] depth, dis;

    public static void main(String[] args) {
        init();

        getAnswer();

        for (int i = 1; i <= N; i++)
            System.out.print(parents[i] + " ");
    }

    private static void getAnswer() {
        int i, j, leavesIndex, brotherNum;
        int[] brothers = new int[100];
        while (M > 1) {
            for (i = 0; i < A[M]; i++) {
                brotherNum = 0;
                leavesIndex = nodeToleavesIndex(depth[M][i]);
                if (leavesIndex == 101) continue;
                for (j = 0; j < K; j++) {
                    if (dis[leavesIndex][j] == 2)
                        brothers[brotherNum++] = leavesIndexToNode(j);
                }
                if (brotherNum > 0)
                    mergeBrothers(brothers, brotherNum, depth[M][i]);
            }
            mergeLastTwoLayers();
            M--;
        }
    }

    // 合并最后两层
    private static void mergeLastTwoLayers() {
        int i, j, length = 0, brother;
        int[] parentNodes = new int[100];
        for (i = 0; i < A[M - 1]; i++)
            if (!isLeaves(depth[M - 1][i]))
                parentNodes[length++] = depth[M - 1][i];

        j = 0;
        for (i = 0; i < A[M]; i++) {
            if (parents[depth[M][i]] == 101) {
                parents[depth[M][i]] = parentNodes[j];
                updateParent(parentNodes[j], depth[M][i]);
                j++;
            } else {
                brother = 0 - parents[depth[M][i]];
                parents[depth[M][i]] = parents[brother];
            }
        }

    }

    private static void updateParent(int parentNode, int node) {
        int i, leavesIndex;
        leavesIndex = nodeToleavesIndex(node);
        leaves[leavesIndex] = parentNode;
        for (i = 0; i < K; i++) {
            if (dis[leavesIndex][i] != 0) dis[leavesIndex][i]--;
            if (dis[i][leavesIndex] != 0) dis[i][leavesIndex]--;
        }
    }

    private static boolean isLeaves(int node) {
        for (int i = 0; i < K; i++)
            if (node == leaves[i]) return true;
        return false;
    }

    private static void mergeBrothers(int[] brothers, int brotherNum,
            int thisNode) {
        int i;
        for (i = 0; i < brotherNum; i++) {
            parents[brothers[i]] = 0 - thisNode;
            updateBrothers(brothers[i]);
        }
    }

    private static int nodeToleavesIndex(int node) {
        for (int i = 0; i < K; i++)
            if (node == leaves[i]) return i;
        return 101;
    }

    private static int leavesIndexToNode(int leavesIndex) {
        return leaves[leavesIndex];
    }

    // 兄弟节点合并之后的更新
    private static void updateBrothers(int node) {
        int i, j;
        int leavesIndex = nodeToleavesIndex(node);
        for (i = leavesIndex; i < K - 1; i++)
            for (j = 0; j < K; j++) {
                dis[i][j] = dis[i + 1][j];
            }
        for (i = leavesIndex; i < K - 1; i++)
            for (j = 0; j < K; j++) {
                dis[j][i] = dis[j][i + 1];
            }
        for (i = leavesIndex; i < K - 1; i++)
            leaves[i] = leaves[i + 1];
        K--;
    }

    private static void init() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        A = new int[M + 1];
        parents = new int[N + 1];
        leaves = new int[K];
        depth = new int[M + 1][100];
        dis = new int[K][K];

        int i, j;

        for (i = 1; i <= N; i++)
            parents[i] = 101;
        parents[1] = 0;

        for (i = 1; i <= M; i++)
            A[i] = sc.nextInt();

        for (i = 1; i <= M; i++) {
            for (j = 0; j < A[i]; j++) {
                depth[i][j] = sc.nextInt();
            }
        }

        for (i = 0; i < K; i++)
            leaves[i] = sc.nextInt();

        for (i = 0; i < K; i++)
            for (j = 0; j < K; j++)
                dis[i][j] = sc.nextInt();
    }

}
