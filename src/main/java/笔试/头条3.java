package 笔试;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * 生成每个字符串所有可能顺序，放入HashSet，然后O(n)比较
 */
public class 头条3 {
    static boolean flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t, n;
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            sc.nextLine();
            String[] strs = new String[n];
            flag = false;
            for (int j = 0; j < n; j++)
                strs[j] = sc.nextLine();
            String str1rev = reverse(strs[0]);
            String str = str1rev + str1rev + strs[0] + strs[0];
            for (int j = 1; j < n && !flag; j++) {
                if (str.contains(strs[j])) {
                    out.println("Yeah");
                    flag = true;
                    break;
                }
            }
            if (!flag)
                out.println("Sad");
        }
    }

    public static boolean isHW(String str1, String str2) {
        String str1rev = reverse(str1);
        return (str1rev + str1rev + str1 + str1).contains(str2);
    }

    public static String reverse(String str) {
        StringBuffer sb = new StringBuffer(str);
        int l = 0, r = sb.length() - 1;
        char t;
        while (l < r) {
            t = sb.charAt(l);
            sb.setCharAt(l, sb.charAt(r));
            sb.setCharAt(r, t);
        }
        return sb.toString();
    }
}
