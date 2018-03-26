package key_package;

public class K105ConstructBinaryTreefromPreorderandInorderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int rootIndex = getIndex(inorder, preorder[0]);
        int[] leftPreOrder = new int[rootIndex],
                leftInOrder = new int[rootIndex];
        int[] rightPreOrder = new int[preorder.length - rootIndex - 1],
                rightInOrder = new int[preorder.length - rootIndex - 1];
        System.arraycopy(preorder, 1, leftPreOrder, 0, rootIndex);
        System.arraycopy(inorder, 0, leftInOrder, 0, rootIndex);

        System.arraycopy(preorder, 1 + rootIndex, rightPreOrder, 0,
                preorder.length - rootIndex - 1);
        System.arraycopy(inorder, rootIndex + 1, rightInOrder, 0,
                preorder.length - rootIndex - 1);
        root.left = buildTree(leftPreOrder, leftInOrder);
        root.right = buildTree(rightPreOrder, rightInOrder);
        return root;
    }

    private int getIndex(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };
        System.out.println(
                new K105ConstructBinaryTreefromPreorderandInorderTraversal()
                        .buildTree(preorder, inorder));
    }

}
