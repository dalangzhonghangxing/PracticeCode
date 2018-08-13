package 剑指offer;

import java.util.*;

import static java.lang.System.out;

public class 把数组排成最小数 {

    public static void getMinNumber(int[] array) {
        List<String> numbers = new ArrayList<>();
        for (int a : array) {
            numbers.add(String.valueOf(a));
        }
        Collections.sort(numbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo((o2 + o1));
            }
        });
        StringBuffer ans = new StringBuffer();
        for (String number : numbers)
            ans.append(number);
        out.println(ans.toString());
    }

    public static void main(String[] args) {
        int[] array = {333332222, 222221111, 321321321, 333332222, 222221111, 321321321, 333332222, 222221111, 321321321, 333332222, 222221111, 321321321};
        getMinNumber(array);
    }
}
