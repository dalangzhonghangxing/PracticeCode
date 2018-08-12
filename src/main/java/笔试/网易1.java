package 笔试;

        import java.util.Scanner;

public class 网易1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int k = sc.nextInt();
        int[] a = new int[n];
        int[] t = new int[n];
        long ts = 0;//总分
        long get = 0;//以及获取的分数

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            ts += a[i];
        }

        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
            if (t[i] == 1)
                get += a[i];
        }

        long c = 0;
        if (k >= n) {
            System.out.print(ts);
            return;
        }

        for (int i = 0; i < k; i++) {
            if (t[i] == 0) {
                c += a[i];
            }
        }

        long cc = c;
        for (int i = k; i < n; i++) {
            if (t[i] == 0) c += a[i];
            if (t[i - k] == 0) c -= a[i - k];
            if (cc < c) cc = c;
        }
        System.out.print(get + cc);
    }
}
