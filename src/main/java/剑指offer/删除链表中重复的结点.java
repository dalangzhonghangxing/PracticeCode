package 剑指offer;

public class 删除链表中重复的结点 {
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null) return null;
        ListNode ans = new ListNode(-1), q = pHead, p = q.next;
        ListNode s = ans;
        int count;
        while (q != null) {
            count = 0;
            while (p != null && q.val == p.val) {// 找到pq不一样的一处节点
                p = p.next;
                count++;
            }
            if (count == 0) {// 说明q节点只有一个
                ans.next = q;
                ans = ans.next;
                ans.next = null;
            }
            if (p == null) break;
            q = p;
            p = p.next;
        }
        return s.next;
    }

    public static void main(String[] args) {
        ListNode pHead = new ListNode(1), q;
        q = pHead;
        q.next = new ListNode(1);
        q = q.next;
        q.next = new ListNode(2);
        q = q.next;
        q.next = new ListNode(3);
        q = q.next;
        q.next = new ListNode(3);
        q = q.next;
        q.next = new ListNode(4);
        q = q.next;
        q.next = new ListNode(5);
        q = q.next;
        q.next = new ListNode(5);
        new 删除链表中重复的结点().deleteDuplication(pHead);
    }
}
