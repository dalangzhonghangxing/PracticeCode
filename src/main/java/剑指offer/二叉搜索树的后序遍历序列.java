package 剑指offer;

/**
 * 后序序列的最后一个元素x是整个二叉树的根，并且能够将剩下的元素分词两段，一段的元素都小于x，另一端的元素都大于x。
 *
 */
public class 二叉搜索树的后序遍历序列 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if(sequence == null || sequence.length ==0)
            return false;
        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    public boolean VerifySquenceOfBST(int[] sequence, int left, int right) {
        if (left >= right) return true;
        int x = sequence[right], i, mid;
        for (i = left; i <= right && sequence[i] < x; i++);
        mid = i;
        for (; i <= right; i++) {
            if (sequence[i] < x) return false;
        }
        return VerifySquenceOfBST(sequence, left, mid - 1)
                && VerifySquenceOfBST(sequence, mid, right-1);
    }

    public static void main(String[] args) {
        int[] a = { };
        System.out.println(new 二叉搜索树的后序遍历序列().VerifySquenceOfBST(a));
    }
}
