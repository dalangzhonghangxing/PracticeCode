package 笔试;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * 把等式看成一张图
 */
public class 头条4 {
    static boolean flag = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, LinkedList<String>> graph = new HashMap<>();
        int n, m;
        String[] values;
        values = sc.nextLine().split(" ");
        n = Integer.valueOf(values[0]);
        m = Integer.valueOf(values[1]);
        for (int i = 0; i < n; i++) {
            values = sc.nextLine().split(" ");
            LinkedList<String> list = graph.getOrDefault(values[0], new LinkedList<>());
            list.add(values[4] + "#" + values[2]);
            graph.put(values[0], list);
        }

        for (int i = 0; i < m; i++) {
            values = sc.nextLine().split(" ");
            LinkedList<String> list = graph.getOrDefault(values[0], new LinkedList<>());
            if (list.size() == 0) {
                out.println("cannot_answer");
                break;
            }
            flag = false;
            for (String str : list) {
                if(!str.split("#")[0].equals(values[2]))
                    getAns(graph, str.split("#")[0], values[2], Integer.parseInt(str.split("#")[1]));
            }
            if (!flag)
                out.println("cannot_answer");
        }
    }

    public static void getAns(Map<String, LinkedList<String>> graph, String u, String v, int value) {
        if (flag)
            return;
        if (u.equals(v)) {
            out.println(value);
            flag = true;
        }

        for (String str : graph.getOrDefault(u, new LinkedList<>())) {
            getAns(graph, str.split("#")[0], v, value - Integer.parseInt(str.split("#")[1]));
        }
    }
}
