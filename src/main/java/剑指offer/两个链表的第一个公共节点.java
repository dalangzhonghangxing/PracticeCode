package 剑指offer;

public class 两个链表的第一个公共节点 {
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int length1 = 0, length2 = 0;
        ListNode p, p1, p2;

        p = pHead1;
        while (p != null) {
            length1++;
            p = p.next;
        }
        p = pHead2;
        while (p != null) {
            length2++;
            p = p.next;
        }

        p1 = pHead1;
        p2 = pHead2;
        int diff;
        if (length1 > length2) {
            diff = length1 - length2;
            while (diff-- > 0)
                p1 = p1.next;
        } else {
            diff = length2 - length1;
            while (diff-- > 0)
                p2 = p2.next;
        }

        while (p1 != null && p2 != null && p1.val != p2.val) {
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p1 != null && p2 != null)
            return p1;
        return null;
    }

    public static void main(String[] args) {

    }
}
