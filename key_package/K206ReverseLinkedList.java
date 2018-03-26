package key_package;

public class K206ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode res = head, p = head.next, q;
        res.next = null;
        while (p != null) {
            q = p.next;
            p.next = res;
            res = p;
            p = q;
        }
        return res;
    }
}
