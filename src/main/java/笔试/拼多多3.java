package 笔试;

import java.util.Arrays;
import java.util.Scanner;

public class 拼多多3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        if (line.equals("")) {
            System.out.println(0);
            return;
        }

        String[] splits = line.split("\\s+");
        int N = splits.length;
        int[] weight = new int[N];
        boolean[] flag = new boolean[N];
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.valueOf(splits[i]);
        }
        // 把重量排序
        Arrays.sort(weight);

        int res = 0;
        int right = N - 1;
        int tmp, i;
        // 从大往小遍历,flag是计算一个货物是否用过
        for (; right >= 0; right--) {
            if (flag[right]) continue;
            if (weight[right] >= 300) {// 如果货物重量300，直接上车
                res++;
                flag[right] = true;
                continue;
            }
            
            // 当前货物没满300，从大往小找相加<=300的
            tmp = weight[right];
            i = right - 1;
            while (i >= 0 && tmp < 300) {
                if (flag[i]) {
                    i--;
                    continue;
                }
                if (tmp + weight[i] <= 300) {
                    // 找到另一个货物
                    tmp += weight[i];
                    flag[i] = true;
                }
                i--;
            }
            res++;

        }
        System.out.println(res);
    }
}
