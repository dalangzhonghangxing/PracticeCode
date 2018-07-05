package 剑指offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

/**
 * 本题关键是如何记录下random node的指针，不能通过label来确定哪些节点的ramdom指针指向了它，因为label可以重复
 **/
public class 复杂链表的复制 {
    public RandomListNode Clone(RandomListNode pHead) {
        RandomListNode ans = new RandomListNode(0);
        RandomListNode q, p = pHead;
        RandomListNode newNode;
        if (pHead == null) return null;
        // 在每个老节点后面创建一个新节点
        while (p != null) {
            newNode = new RandomListNode(p.label);
            newNode.next = p.next;
            p.next = newNode;
            p = newNode.next;
        }

        // 复制random，每个newNode.random = oldNode.random.next;
        p = pHead;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }

        // 将新节点从链表中剥离出来
        q = ans;
        p = pHead;
        while (p != null) {
            q.next = p.next;
            p = p.next.next;
            q = q.next;
        }
        return ans.next;
    }

    public static void main(String[] args) {
        // 1,2,3,4,5,3,5,#,2,#
        RandomListNode a, b;
        a = new RandomListNode(1);
        b = a;
        a.next = new RandomListNode(2);
        a = a.next;
        a.next = new RandomListNode(3);
        a = a.next;
        a.next = new RandomListNode(4);
        a = a.next;
        a.next = new RandomListNode(5);
        a = a.next;
        a.next = new RandomListNode(3);
        a = a.next;
        a.next = new RandomListNode(5);
        a = a.next;
        a.next = new RandomListNode(-1);
        a = a.next;
        a.next = new RandomListNode(2);
        a = a.next;
        a.next = new RandomListNode(-1);
        a = a.next;
    }
}
