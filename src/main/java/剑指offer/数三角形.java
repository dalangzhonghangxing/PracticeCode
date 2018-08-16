package 剑指offer;

import java.util.*;

import static java.lang.System.out;

public class 数三角形 {
    static class Pair {
        double x, y;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Pair> pairs = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            Pair p = new Pair();
            p.x = sc.nextInt();
            p.y = sc.nextInt();
            pairs.add(p);
        }

        int ans = 0;

        int size = pairs.size();
        for (int i = 0; i < size; i++)
            for (int j = i + 1; j < size; j++)
                for (int k = j + 1; k < size; k++) {
                    if (isTriangle(pairs.get(i), pairs.get(j), pairs.get(k)))
                        ans++;
                }
        out.println(ans);
    }

    public static boolean isTriangle(Pair a, Pair b, Pair c) {
        // 判断共线
        if (a.x == b.x && a.x == c.x) return false;
        if (a.y == b.y && a.y == c.y) return false;
        if ((a.y - b.y) / (a.x - b.x) == (a.y - c.y) / (a.x - c.x))
            return false;

        double l1 = getLength(a, b);
        double l2 = getLength(a, c);
        double l3 = getLength(b, c);
        if ((l1 + l2) > l3 && Math.abs(l1 - l2) < l3)
            return true;
        return false;
    }

    public static double getLength(Pair a, Pair b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }
}

/*
77
13 -8
17 -17
-14 0
-1 4
-8 -6
-6 7
-14 -8
0 -7
-20 -6
-1 -4
7 6
-4 -10
-20 4
8 15
12 -6
-20 -12
8 -16
14 -16
-13 19
18 -19
-8 -13
-11 6
-16 17
17 -3
3 2
6 -19
-10 13
-8 -4
8 -7
9 -14
-11 18
9 -19
-13 5
6 0
-13 -4
-15 2
-8 10
0 -13
13 -7
16 18
13 -2
11 -13
2 -14
-17 9
9 2
11 17
-11 -17
-12 -17
7 -9
11 -6
-16 8
-4 -19
3 13
-11 -14
-3 11
13 14
19 4
3 -14
10 19
-19 -8
-10 11
-16 12
-8 18
13 -20
-15 -2
-3 -11
19 -20
6 -18
16 6
-9 12
-5 -15
-11 3
-14 5
-15 -5
15 4
-9 -17
-8 11
 */