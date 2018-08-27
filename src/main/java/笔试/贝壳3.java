package 笔试;

import java.util.*;

import static java.lang.System.out;

public class 贝壳3 {
    static class Time {
        int l, r, index;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Time> times = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Time t = new Time();
            t.l = sc.nextInt();
            t.r = sc.nextInt();
            t.index = i + 1;
            times.add(t);
        }

        Collections.sort(times, new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                if (o1.l != o2.l) {
                    return o1.l - o2.l;
                }
                return o2.r - o1.r;
            }
        });

        if (!isConflict(times, -1)) {
            out.println(times.size());
            out.print(1);
            for (int i = 2; i <= times.size(); i++)
                out.print(" " + i);
            return;
        }

        int ans = 0;
        List<Integer> canDeleteIndex = new ArrayList<>();
        for (int i = 0; i < times.size(); i++) {
            if (isConflict(times, i)) {
                continue;
            }
            ans++;
            canDeleteIndex.add(times.get(i).index);
        }
        out.println(ans);
        if (ans != 0) {
            Collections.sort(canDeleteIndex);
            out.print(canDeleteIndex.get(0));
            for (int i = 1; i < canDeleteIndex.size(); i++)
                out.print(canDeleteIndex.get(1));
        }
    }

    public static boolean isConflict(List<Time> times, int t) {
        int j = 0;
        if (t == 0)
            j = 1;
        if (j >= times.size()) return true;
        int cr = times.get(j).r;
        for (int i = j + 1; i < times.size(); i++) {
            if (i == t) continue;
            if (times.get(i).l >= cr) {
                cr = times.get(i).r;
            } else {
                return true;
            }
        }
        return false;
    }
}