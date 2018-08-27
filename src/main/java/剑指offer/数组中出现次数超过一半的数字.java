package 剑指offer;

import static java.lang.System.out;

public class 数组中出现次数超过一半的数字 {
    public int MoreThanHalfNum_Solution(int[] array) {
        int c = 1, number = array[0];
        for (int i = 1; i < array.length; i++) {
            if (c == 0) {
                c = 1;
                number = array[i];
            } else {
                if (number == array[i])
                    c++;
                else
                    c--;
            }
        }
        if(c == 0)
            return 0;
        return number;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 1, 3, 1,4};
        out.println(new 数组中出现次数超过一半的数字().MoreThanHalfNum_Solution(array));
    }
}
