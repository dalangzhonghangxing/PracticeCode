package 剑指offer;

import java.util.*;

import static java.lang.System.out;

public class 矩形重叠 {
    static class Square {
        int x1, y1, x2, y2;
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        List<Square> squares = new ArrayList<>(n);
        int x[] = new int[2 * n];
        int y[] = new int[2 * n];
        for (int j = 0; j < n; j++) {
            Square s = new Square();
            s.x1 = sc.nextInt();
            x[j] = s.x1;
            squares.add(s);
        }
        for (int j = 0; j < n; j++) {
            squares.get(j).y1 = sc.nextInt();
            y[j] = squares.get(j).y1;
        }
        for (int j = 0; j < n; j++) {
            squares.get(j).x2 = sc.nextInt();
            x[j + n] = squares.get(j).x2;
        }
        for (int j = 0; j < n; j++) {
            squares.get(j).y2 = sc.nextInt();
            y[j + n] = squares.get(j).y2;
        }

        int ans = 0;
        for (int i = 0; i < 2 * n; i++) {
            for (int j = 0; j < 2 * n; j++) {
                ans = Math.max(getCNT(x[i], y[j], squares), ans);
            }
        }
        out.println(ans);
    }

    public static int getCNT(int x, int y, List<Square> squares) {
        int cnt = 0;
        for (Square square : squares) {
            if (square.x1 <= x && square.y1 <= y && square.x2 >x && square.y2 >y)
                cnt++;
        }
        return cnt;
    }
}
