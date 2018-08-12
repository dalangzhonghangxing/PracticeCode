package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class 按之字形顺序打印二叉树 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> currentNodeQueue = new LinkedList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        currentNodeQueue.add(pRoot);
        ArrayList<Integer> currentLine = new ArrayList<>();
        int i = 0;
        while (!currentNodeQueue.isEmpty()) {
            TreeNode currentNode = currentNodeQueue.poll();
            currentLine.add(currentNode.val);

            if (currentNode.left != null) nodeQueue.add(currentNode.left);
            if (currentNode.right != null) nodeQueue.add(currentNode.right);
            if (currentNodeQueue.isEmpty()) {// 一层遍历完
                if (i % 2 == 0)
                    res.add(currentLine);
                else {
                    res.add(inverse(currentLine));
                }
                while (!nodeQueue.isEmpty())
                    currentNodeQueue.add(nodeQueue.poll());
                currentLine = new ArrayList<>(currentNodeQueue.size());
                i++;
            }
        }

        return res;
    }

    public ArrayList<Integer> inverse(ArrayList<Integer> list) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            res.add(list.get(i));
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode pRoot = new TreeNode(8);
        pRoot.left = new TreeNode(6);
        pRoot.left.left = new TreeNode(5);
        pRoot.left.right = new TreeNode(7);
        pRoot.right = new TreeNode(10);
        pRoot.right.left = new TreeNode(9);
        pRoot.right.right = new TreeNode(10);
        new 按之字形顺序打印二叉树().Print(pRoot);
    }
}
