package 剑指offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class 字符串的排列 {
    public ArrayList<String> Permutation(String str) {
        Set<String> s = new HashSet<>();
        char[] c = str.toCharArray();
        backtracking(c, 0, s);
        ArrayList<String> ans = new ArrayList<>();
        ans.addAll(s);
        Collections.sort(ans);
        return ans;
    }

    public void backtracking(char[] c, int i, Set<String> ans) {
        if (i == c.length - 1) {
            ans.add(String.valueOf(c));
            return;
        }
        for (int j = i ; j < c.length; j++) {
            swap(c, i, j);
            backtracking(c, i + 1, ans);
            swap(c, i, j);
        }
    }

    public void swap(char[] c, int i, int j) {
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }

    public static void main(String[] args) {
        new 字符串的排列().Permutation("aa");
    }
}
