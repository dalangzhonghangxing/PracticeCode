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
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) return null;
        ListNode q;
        while (pHead.next != null) {
            q = pHead.next;
            pHead.next = null;
            pHead = q;
        }
        return pHead;
    }
}
