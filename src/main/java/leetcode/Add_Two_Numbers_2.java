package leetcode;
import java.math.BigInteger;
import java.util.Scanner;

public class Add_Two_Numbers_2 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // String a1 = decode(l1);
        // String a2 = decode(l2);
        // BigInteger p = new BigInteger(a1).add(new BigInteger(a2));
        // return encode(p.toString());
        ListNode head = new ListNode(-1);
        ListNode p = head;
        int add;
        int j = 0;
        while (l1 != null || l2 != null) {
            if (l1 == null)
                add = l2.val + j;
            else if (l2 == null)
                add = l1.val + j;
            else
                add = l1.val + l2.val + j;
            ListNode t = new ListNode(add % 10);
            j = add / 10;
            p.next = t;
            p = t;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (j != 0) {
            ListNode t = new ListNode(1);
            p.next = t;
        }

        return head.next;
    }

    private String decode(ListNode ln) {
        StringBuffer sb = new StringBuffer();
        sb.append(ln.val);
        while (ln.next != null) {
            sb.append(ln.next.val);
            ln = ln.next;
        }

        return sb.reverse().toString();
    }

    private ListNode encode(String p) {
        ListNode head = new ListNode(
                Integer.valueOf(String.valueOf(p.charAt(p.length() - 1))));
        ListNode q = head;
        for (int i = p.length() - 2; i >= 0; i--) {
            ListNode t = new ListNode(
                    Integer.valueOf(String.valueOf(p.charAt(i))));
            q.next = t;
            q = t;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] values = sc.nextLine().split(",");
        ListNode head1 = new ListNode(Integer.valueOf(values[0]));
        ListNode q = head1;
        for (int i = 1; i < values.length; i++) {
            ListNode t = new ListNode(Integer.valueOf(values[i]));
            q.next = t;
            q = t;
        }

        values = sc.nextLine().split(",");
        ListNode head2 = new ListNode(Integer.valueOf(values[0]));
        q = head2;
        for (int i = 1; i < values.length; i++) {
            ListNode t = new ListNode(Integer.valueOf(values[i]));
            q.next = t;
            q = t;
        }

        new Add_Two_Numbers_2().addTwoNumbers(head1, head2);
    }
}
