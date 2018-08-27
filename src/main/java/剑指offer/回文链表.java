package 剑指offer;

import static java.lang.System.out;

public class 回文链表 {
    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode getMidNode(ListNode root) {
        if (root == null)
            return null;
        ListNode midNode, p;
        p = root.next;
        if (p == null)
            return root;
        p = p.next;
        midNode = root;
        while (p != null) {
            midNode = midNode.next;
            p = p.next;
            if (p == null) {
                break;
            } else {
                p = p.next;
            }
        }
        return midNode.next;
    }

    public static ListNode reserve(ListNode root) {
        ListNode head = root, p = head.next, q;
        head.next = null;
        while (p != null) {
            q = head;
            head = p;
            p = p.next;
            head.next = q;
        }
        return head;
    }

    public static boolean ishw(ListNode root) {
        ListNode nroot = reserve(getMidNode(root));
        while (nroot != null) {
            if (root.val != nroot.val)
                return false;
            nroot = nroot.next;
            root = root.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(1);
        out.println(ishw(root));
    }
}
