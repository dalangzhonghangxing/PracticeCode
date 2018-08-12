package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * 先排序，然后从头到尾遍历，如果d[i+1]-d[i]<=10，那么它们就是连通的；如果d[i+1]-d[i]<=20，那么补一道题让它们连通，同时ans++。否则不连通。
 * 最后再计算连通的题目，还需要几道题，即if (size % 3 != 0) ans += 3 - (size % 3);
 */
public class 头条校招 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n];
        for (int i = 0; i < n; i++)
            d[i] = sc.nextInt();
        Arrays.sort(d);

        int ans = 0, segSize = 1;
        List<Integer> segmentsSize = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            if (d[i + 1] - d[i] <= 20) {
                if (d[i + 1] - d[i] <= 10) {
                    segSize++;
                } else {
                    segSize += 2;
                    ans++;
                }
            } else {
                segmentsSize.add(segSize);
                segSize = 1;
            }
        }
        segmentsSize.add(segSize);

        for (Integer size : segmentsSize) {
            if (size % 3 != 0) {
                ans += 3 - (size % 3);
            }
        }

        out.println(ans);

    }
}
