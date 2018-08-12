package 剑指offer;

public class 树的子结构 {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null || root1 == null) return false;
        if (isSameTree(root1, root2)) return true;
        if (HasSubtree(root1.left, root2)) return true;
        if (HasSubtree(root1.right, root2)) return true;
        return false;
    }

    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root1.val == root2.val)
            return isSameTree(root1.left, root2.left)
                    && isSameTree(root1.right, root2.right);
        else
            return false;
    }
}
