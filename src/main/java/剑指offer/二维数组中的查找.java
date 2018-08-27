package 剑指offer;

import java.util.Arrays;

public class 二维数组中的查找 {
    public static boolean Find(int target, int[][] array) {
        for(int i = 0;i<array.length;i++){
            if(Arrays.binarySearch(array[i],target) != -1)
                return true;
        }
        return false;
    }

    public static boolean find(int target, int[][] array, int x, int y) {
        if (x < 0 || y >= array[0].length)
            return false;
        int c = array[x][y];
        if (target == c)
            return true;
        if (target > c)
            return find(target, array, x, y + 1);
        else
            return find(target, array, x - 1, y);
    }

    public static void main(String[] args) {

    }
}
