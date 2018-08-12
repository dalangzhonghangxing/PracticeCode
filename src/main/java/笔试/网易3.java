package 笔试;

import java.util.Scanner;

import static java.lang.System.out;

public class 网易3 {

    public static long C(int low, int high, int k) {
        long a = 1;
        for (int i = 1; i <= high; i++) {
            a = (a * low--) / i;
            if (a > k) return -1;
        }
        return a;

    }

    public static long getCnt(int n, int m, int k) {
        return C(n + m, m, k);
    }

    public static void getAns(int n, int m, int k) {
        long cnt = getCnt(n, m, k);
        if (cnt != -1 && k > cnt) {
            out.println(-1);
            return;
        }

        StringBuffer ans = new StringBuffer();
        while (k != 0 && m > 0 && n > 0) {
            cnt = 1;
            if (n - 1 > 0) {//如果还有n
                cnt = getCnt(n - 1, m, k);
            }
            if (cnt < k && cnt != -1) {//当前位以a打头的数量不够
                ans.append("z");
                k -= cnt;
                m--;
            } else {
                ans.append("a");
                n--;
                if (k == 0)
                    break;
            }
        }
        while (n > 0) {
            ans.append("a");
            n--;
        }
        while (m > 0) {
            ans.append("z");
            m--;
        }
        out.println(ans.toString());
    }

    public static void main(String[] args) {
        int n, m, k;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        getAns(n, m, k);
    }
}
