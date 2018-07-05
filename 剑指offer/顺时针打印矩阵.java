package 剑指offer;

import java.util.ArrayList;

public class 顺时针打印矩阵 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return null;

        int rowStart = 0, rowEnd = matrix.length-1, colStart = 0,
                colEnd = matrix[0].length-1;
        ArrayList<Integer> ans = new ArrayList<>();
        printOut(matrix, rowStart, rowEnd, colStart, colEnd, ans);
        return ans;
    }

    public void printOut(int[][] matrix, int rowStart, int rowEnd, int colStart,
            int colEnd, ArrayList<Integer> ans) {
        int i;
        if (rowStart > rowEnd || colStart > colEnd) return;
        if (rowStart == rowEnd) {// 只有一行
            for (i = colStart; i <= colEnd; i++)
                ans.add(matrix[rowStart][i]);
            return;
        }
        if (colStart == colEnd) {// 只有一列
            for (i = rowStart; i <= rowEnd; i++)
                ans.add(matrix[i][colStart]);
            return;
        }
        for (i = colStart; i < colEnd; i++)
            ans.add(matrix[rowStart][i]);
        for (i = rowStart; i < rowEnd; i++)
            ans.add(matrix[i][colEnd]);
        for (i = colEnd; i > colStart; i--)
            ans.add(matrix[rowEnd][i]);
        for (i = rowEnd; i > rowStart; i--)
            ans.add(matrix[i][colStart]);
        printOut(matrix, rowStart + 1, rowEnd - 1, colStart + 1, colEnd - 1,
                ans);
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1 } };
        new 顺时针打印矩阵().printMatrix(matrix);
    }
}
