/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package 剑指offer;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class 重建二叉树 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return reConstructBinaryTree(pre, in, 0, pre.length - 1, 0, in.length - 1);

    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in, int pleft, int pright, int ileft, int iright) {
        if (pleft > pright) return null;
        if (pleft == pright) {
            return new TreeNode(pre[pleft]);
        }
        int splitIndex = indexFirstPreAtIn(pre[pleft], in, ileft, iright);
        TreeNode root = new TreeNode(pre[pleft]);
        root.left = reConstructBinaryTree(pre, in, pleft + 1, pleft + (splitIndex - ileft), ileft, splitIndex - 1);
        root.right = reConstructBinaryTree(pre, in, pleft + (splitIndex - ileft) + 1, pright, splitIndex + 1, iright);
        return root;
    }

    public int indexFirstPreAtIn(int firstPre, int[] in, int ileft, int iright) {
        for (int i = ileft; i <= iright; i++)
            if (in[i] == firstPre)
                return i;
        return -1;
    }

    public static void main(String[] avgs) {
        int[] pre = {1, 2, 3, 4, 5, 6, 7}, in = {3, 2, 4, 1, 6, 5, 7};
        new 重建二叉树().reConstructBinaryTree(pre, in);
    }
}
