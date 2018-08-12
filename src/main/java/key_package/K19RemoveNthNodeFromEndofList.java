package key_package;

public class K19RemoveNthNodeFromEndofList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int k = 0;
        ListNode q = head, p = head;
        while (k < n - 1) {
            q = q.next;
            k++;
        }
        if (q.next == null) { return head.next; }
        while (q.next.next != null) {
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode ln = new ListNode(1);
        ln.next = new ListNode(2);
        new K19RemoveNthNodeFromEndofList().removeNthFromEnd(ln, 2);
    }
}
