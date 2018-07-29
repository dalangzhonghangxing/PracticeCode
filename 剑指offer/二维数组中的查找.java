/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package 剑指offer;

public class 二维数组中的查找 {
    public boolean Find(int target, int[][] array) {
        return Find(target, array, 0, array.length, 0, array[0].length);
    }

    public boolean Find(int target, int[][] array, int rowL, int rowR, int colL, int colR) {
        if (rowL > rowR || colL > colR || colL < 0 || colR > array[0].length || rowL < 0 || rowR > array.length)
            return false;
        int rowM = (rowL + rowR) / 2, colM = (colL + colR) / 2;
        if (array[rowR][colM] == target)
            return true;

        //只剩最后一个元素，也不是target
        if (rowL == rowR && colL == colR)
            return false;

        if (array[rowR][colM] > target)
            return Find(target, array, rowL, rowM - 1, colL, colR) ||
                    Find(target, array, rowM, rowR, colL, colM - 1);
        else
            return Find(target, array, rowL, rowR, colM + 1, colR) ||
                    Find(target, array, rowM - 1, rowR, colL, colM);

    }
}
