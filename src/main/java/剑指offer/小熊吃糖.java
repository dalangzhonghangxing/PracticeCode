package 剑指offer;

import java.util.*;

import static java.lang.System.out;

public class 小熊吃糖 {
    static class Panda {
        int f, h,index;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        int s[] = new int[m];
        boolean flag[] = new boolean[m];
        List<Panda> pandas = new ArrayList<>();
        for (int i = 0; i < m; i++)
            s[i] = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Panda p = new Panda();
            p.f = sc.nextInt();
            p.h = sc.nextInt();
            p.index = i;
            pandas.add(p);
        }
        Collections.sort(pandas, new Comparator<Panda>() {
            @Override
            public int compare(Panda o1, Panda o2) {
                if (o1.f != o2.f)
                    return o2.f - o1.f;
                return o1.h - o2.h;
            }
        });
        Arrays.sort(s);

        int [] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[pandas.get(i).index] = eat(pandas.get(i), flag, s);
        }
        for(int i = 0;i<n;i++)
            out.println(ans[i]);
    }

    public static int eat(Panda p, boolean[] flag, int[] s) {
        for (int i = s.length - 1; i >= 0; i--) {
            if (flag[i])
                continue;
            if (p.h >= s[i]) {
                flag[i] = true;
                p.h -= s[i];
                if (p.h == 0 || p.h < s[0])
                    return p.h;
            }
        }
        return p.h;
    }
}
