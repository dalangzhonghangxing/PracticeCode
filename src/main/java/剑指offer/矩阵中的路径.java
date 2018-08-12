package 剑指offer;

import java.util.Arrays;

public class 矩阵中的路径 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean flag[] = new boolean[matrix.length];
        Arrays.fill(flag, false);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (matrix[getPosition(i, j, cols)] == str[0]) {
                    if (hasPath(matrix, rows, cols, str, flag, 0, i, j))
                        return true;
                }
        return false;

    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str,
            boolean flag[], int index, int x, int y) {
        if (index >= str.length) return true;
        if (x < 0 || x >= rows || y < 0 || y >= cols
                || flag[getPosition(x, y, cols)] == true)
            return false;
        if (matrix[getPosition(x, y, cols)] == str[index]) {
            flag[getPosition(x, y, cols)] = true;
            if (hasPath(matrix, rows, cols, str, flag, index + 1, x - 1, y))
                return true;
            if (hasPath(matrix, rows, cols, str, flag, index + 1, x + 1, y))
                return true;
            if (hasPath(matrix, rows, cols, str, flag, index + 1, x, y - 1))
                return true;
            if (hasPath(matrix, rows, cols, str, flag, index + 1, x, y + 1))
                return true;
        }
        flag[getPosition(x, y, cols)] = false;
        return false;
    }

    public int getPosition(int x, int y, int cols) {
        return x * cols + y;
    }

    public static void main(String[] args) {
        System.out.println(new 矩阵中的路径().hasPath("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(), 5,
                8, "SGGFIECVAASABCEHJIGQEM".toCharArray()));
    }
}
