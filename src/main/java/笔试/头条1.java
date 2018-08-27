package 笔试;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * 并查集
 */
public class 头条1 {
    public static void init(int[] set) {
        for (int i = 1; i < set.length; i++)
            set[i] = i;
    }

    public static int getGroup(int[] set, int index) {
        while (set[index] != index) {
            set[index] = set[set[index]];
            index = set[index];
        }
        return index;
    }

    public static void union(int[] set, int index1, int index2) {
        int group1 = getGroup(set, index1), group2 = getGroup(set, index2);
        if (group1 != group2) {
            set[group2] = group1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, set[];
        n = sc.nextInt();
        set = new int[n + 1];
        init(set);

        String line, values[];
        int v;
        sc.nextLine();
        for (int i = 1; i <= n; i++) {
            line = sc.nextLine();
            values = line.split(" ");
            for (String value : values) {
                v = Integer.parseInt(value);
                if (v == 0) {
                    break;
                }
                union(set, i, v);
            }
        }
        Set<Integer> ans = new HashSet<>();
        for (int i = 1; i < set.length; i++) {
            ans.add(getGroup(set, i));
        }
        out.println(ans.size());
    }
}
