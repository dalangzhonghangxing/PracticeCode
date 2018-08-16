package 剑指offer;

import java.util.Scanner;

import static java.lang.System.out;

public class 列表补全 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int o, n, l1, l2;
        o = sc.nextInt();
        n = sc.nextInt();
        l1 = sc.nextInt();
        l2 = sc.nextInt();

        int start1 = 0, start2 = 0, end1 = 0, end2 = 0;

        if (o < l1) {
            start1 = o;
            if (o + n < l1) {
                end1 = o + n;
            } else {
                end1 = l1;
                end2 = o + n - l1;
            }
        } else {
            start1 = l1;
            end1 = l1;
            end2 = Math.min(o + n - l1, l2);
            start2 = Math.min(o - l1, l2);
        }

        out.println(start1 + " " + end1 + " " + start2 + " " + end2);
    }

}
