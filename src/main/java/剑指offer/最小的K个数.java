package 剑指offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class 最小的K个数 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || input.length == 0 || k == 0) return res;
        Queue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());

        for (int i : input) {
            if (queue.size() < k) {
                queue.add(i);
            } else if (i < queue.peek()) {
                queue.remove();
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            res.add(queue.remove());
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = {3, 2, 1, 4, 5, 6, 3, 2, 5, 6, 7, 8, 12, 10};
        new 最小的K个数().GetLeastNumbers_Solution(input, 6);
    }
}
