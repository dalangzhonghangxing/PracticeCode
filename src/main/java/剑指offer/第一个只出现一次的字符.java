package 剑指offer;

import java.util.*;

import static java.lang.System.out;

public class 第一个只出现一次的字符 {

    public static int firstChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        List<Character> list = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            int count = map.getOrDefault(str.charAt(i), 0);
            if (count == 0) {
                list.add(str.charAt(i));
                pos.add(i);
            }
            map.put(str.charAt(i), count + 1);
        }

        for(int i = 0;i<list.size();i++){
            if(map.get(list.get(i)) == 1)
                return pos.get(i);
        }
        return -1;
    }

    public static void main(String[] args) {
        out.println(firstChar("ababc"));
    }
}
