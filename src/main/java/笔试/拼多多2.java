package 笔试;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 拼多多2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        String[] splits = line.split(" ");

        int N = Integer.valueOf(splits[0]);
        int M = Integer.valueOf(splits[1]);

        String[] sa = new String[N];
        String[] ca = new String[N];
        for (int i = 0; i < M; i++) {
            sa[i] = sc.nextLine();
        }

        for (int j = 0; j < N; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(sa[i].charAt(j));
            }

            ca[j] = sort(sb.toString());
        }

        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < N; i++) {
            map.put(ca[i], i);
        }
        Arrays.sort(ca);
        System.out.println((ca[0].equals(ca[1])) ? -1 : map.get(ca[0]));
    }

    public static String sort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
