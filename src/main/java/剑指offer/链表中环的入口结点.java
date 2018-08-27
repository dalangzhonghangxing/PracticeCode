package 剑指offer;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

// 没走过一个节点，就将指针断开，只有入口节点有两个指针指向它，因此最后剩下的就是入口节点
public class 链表中环的入口结点 {
    // 解法一：断链法
    public ListNode EntryNodeOfLoop1(ListNode pHead) {
        if (pHead == null || pHead.next == null) return null;
        ListNode q;
        while (pHead.next != null) {
            q = pHead.next;
            pHead.next = null;
            pHead = q;
        }
        return pHead;
    }

    // 解法二：两根指针追逐
    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) return null;
        ListNode mn = getMeetNode(pHead);
        if (mn == null) return null;
        int n = 1;
        ListNode p = mn.next, q;
        while (p != mn) {
            n++;
            p = p.next;
        }

        p = pHead;
        q = pHead;
        while (n-- > 0)
            p = p.next;
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
    }

    public static ListNode getMeetNode(ListNode pHead) {
        ListNode p = pHead, q = p.next.next;
        while (q != null && q != p) {
            p = p.next;
            if (q.next == null) return null;
            q = q.next.next;
        }
        return q;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = root.next.next;
        EntryNodeOfLoop(root);

    }
}
