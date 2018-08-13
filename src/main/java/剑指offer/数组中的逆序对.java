package 剑指offer;

// 通过分治排序来做
public class 数组中的逆序对 {
    int ans = 0;
    int[] tmp;

    public int InversePairs(int[] array) {
        tmp = new int[array.length];
        mergeSort(array, 0, array.length - 1);
        return ans;
    }

    public void mergeSort(int[] array, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) >> 1;
        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);
        merge(array, start, mid, end);

    }

    public void merge(int[] array, int start, int mid, int end) {
        int j = mid + 1, i = start, k = start;
        while (i <= mid && j <= end) {
            if (array[i] < array[j]) {
                tmp[k++] = array[i++];
            } else {// 有逆序对
                ans += mid - i + 1;
                tmp[k++] = array[j++];
            }
            if (ans > 1000000007) ans %= 1000000007;
        }

        for (; i <= mid; i++)
            tmp[k++] = array[i];
        for (; j <= end; j++)
            tmp[k++] = array[j];
        for (k = start; k <= end; k++)
            array[k] = tmp[k];

    }

    public static void main(String[] args) {
        int[] array = {364, 637, 341, 406, 747, 995, 234, 971, 571, 219, 993,
                407, 416, 366, 315, 301, 601, 650, 418, 355, 460, 505, 360, 965,
                516, 648, 727, 667, 465, 849, 455, 181, 486, 149, 588, 233, 144,
                174, 557, 67, 746, 550, 474, 162, 268, 142, 463, 221, 882, 576,
                604, 739, 288, 569, 256, 936, 275, 401, 497, 82, 935, 983, 583,
                523, 697, 478, 147, 795, 380, 973, 958, 115, 773, 870, 259, 655,
                446, 863, 735, 784, 3, 671, 433, 630, 425, 930, 64, 266, 235,
                187, 284, 665, 874, 80, 45, 848, 38, 811, 267, 575};
        System.out.println(new 数组中的逆序对().InversePairs(array));
        System.out.println(array);
    }
}
