package 剑指offer;

public class 荷兰旗问题 {
    public int[] solve(int[] array) {
        int red = 0, blue = array.length - 1, c;
        while (array[red] == 1)
            red++;
        while (array[blue] == 3)
            blue--;
        c = red;
        while (c <= blue) {
            if (array[c] == 1) {
                if (c == red && array[red] == 1) {
                    c++;
                    red++;
                } else {
                    swap(array, red, c);
                    red++;
                }
            }
            if (array[c] == 3) {
                swap(array, blue, c);
                blue--;
            }
            if (array[c] == 2) c++;
        }
        return array;
    }

    public void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static void main(String[] args) {
        int[] array = { 1, 3, 2, 3, 1, 2, 3, 1 };
        new 荷兰旗问题().solve(array);
    }
}
