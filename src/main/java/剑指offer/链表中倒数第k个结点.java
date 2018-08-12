package 剑指offer;

public class 链表中倒数第k个结点 {
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode first = head;
        while (k > 0 && first != null) {
            first = first.next;
            k--;
        }
        if (k > 0) return null;
        ListNode ans = head;
        while (first != null) {
            first = first.next;
            ans = ans.next;
        }
        return ans;
    }
}
