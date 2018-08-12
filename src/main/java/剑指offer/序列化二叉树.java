package 剑指offer;

public class 序列化二叉树 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int i = 0;

    String Serialize(TreeNode root) {
        if (root == null) return null;
        StringBuilder res = new StringBuilder();
        preTraversal(root, res);
        return res.substring(0, res.length() - 1);
    }

    void preTraversal(TreeNode root, StringBuilder res) {
        res.append(root.val + "|");
        if (root.left != null) {
            preTraversal(root.left, res);
        } else
            res.append("l|");
        if (root.right != null) {
            preTraversal(root.right, res);
        } else
            res.append("r|");
    }

    TreeNode Deserialize(String str) {
        if (str == null) return null;
        String[] val = str.split("\\|");
        return createNode(val);
    }

    TreeNode createNode(String[] val) {
        if (i >= val.length) return null;
        if (val[i].equals("l") || val[i].equals("r")) {
            i++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val[i++]));
        node.left = createNode(val);
        node.right = createNode(val);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        序列化二叉树 a = new 序列化二叉树();
        String ser = a.Serialize(root);
        System.out.println(ser);
        TreeNode de = a.Deserialize(ser);
        System.out.println(de);
    }
}
