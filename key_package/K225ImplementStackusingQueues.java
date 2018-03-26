package key_package;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class K225ImplementStackusingQueues {
    
    Queue<Integer> q1;
    Queue<Integer> q2;
    /** Initialize your data structure here. */
//    public MyStack() {
//        q1 = new PriorityQueue <>();
//        q2 = new PriorityQueue <>();
//    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(q1.size() > 1){
            q2.add(q1.poll());
        }
        Integer res = q1.peek();
        q1 = q2;
        q2 = new PriorityQueue <>();
        return res;
    }

    /** Get the top element. */
    public int top() {
        while(q1.size() > 1){
            q2.add(q1.poll());
        }
        Integer res = q1.peek();
        if(res != null){
            q2.add(res);
        }
        q1 = q2;
        q2.clear();
        return res;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}
