package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

public class 丑数 {

    public int min(int a, int b, int c) {
        int min = Math.min(a, b);
        return Math.min(min, c);
    }

    public int GetUglyNumber_Solution(int index) {
        if (index < 7) return index;
        List<Integer> list = new ArrayList<>(index);
        for (int i = 1; i <= 6; i++)
            list.add(i);
        int two = 3, three = 2, five = 1, c = 7;
        while (c <= index) {
            int m = min(list.get(two) * 2, list.get(three) * 3, list.get(five) * 5);
            list.add(m);
            if (list.get(two) * 2 <= m)
                two++;
            if (list.get(three) * 3 <= m)
                three++;
            if (list.get(five) * 5 <= m)
                five++;
            c++;
        }
        return list.get(index - 1);
    }

    public static void main(String[] args) {
        out.println(new 丑数().GetUglyNumber_Solution(10));

    }
}
