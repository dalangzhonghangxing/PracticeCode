package 剑指offer;

public class 二叉搜索树的第k个结点 {

    int c = 0;
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) return null;
        TreeNode res = null;
        if (pRoot.left != null) res = KthNode(pRoot.left, k);
        if (c == k) return res;
        c++;
        res = pRoot;
        if (c == k) return res;
        if (pRoot.right != null) res = KthNode(pRoot.right, k);
        if (c == k) return res;
        return null;
    }

}
