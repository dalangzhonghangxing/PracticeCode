package 剑指offer;

public class 机器人的运动范围 {
    int res;
    boolean[][] flag;
    int k;
    int rows;
    int cols;

    public int movingCount(int threshold, int rows, int cols) {
        flag = new boolean[rows][cols];
        this.rows = rows;
        this.cols = cols;
        k = threshold;
        move(0, 0);
        return res;
    }

    void move(int x, int y) {
        if (x < 0 || x >= rows || y < 0 || y >= cols || flag[x][y]) return;
        flag[x][y] = true;
        if (calSum(x, y) > k) return;
        res++;
        move(x - 1, y);
        move(x + 1, y);
        move(x, y - 1);
        move(x, y + 1);
    }

    int calSum(int rows, int cols) {
        int sum = 0;
        while (rows > 0) {
            sum += rows % 10;
            rows = rows / 10;
        }
        while (cols > 0) {
            sum += cols % 10;
            cols = cols / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new 机器人的运动范围().movingCount(10, 5, 5));
    }

}
