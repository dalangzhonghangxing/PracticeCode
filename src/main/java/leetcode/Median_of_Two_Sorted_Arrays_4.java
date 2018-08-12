package leetcode;

public class Median_of_Two_Sorted_Arrays_4 {
    private int min(int a, int b) {
        return a < b ? a : b;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    public double findMedianSortedArrays(int[] A, int[] B) {
        int len1 = A.length;
        int len2 = B.length;
        int[] t;
        if (len1 > len2) {
            t = B;
            B = A;
            A = t;
            len1 = A.length;
            len2 = B.length;
        }

        int min = 0, max = len1, half = (len1 + len2 + 1) / 2;

        while (min <= max) {
            int i = (min + max) / 2;
            int j = half - i;

            if (i < max && B[j - 1] > A[i])
                min = i + 1;
            else if (i > min && A[i - 1] > B[j])
                max = i - 1;
            else {
                int minRight;
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                
                if ((len1 + len2) % 2 == 1) {
                    return maxLeft;
                } else {
                    if (i == len1)
                        minRight = B[j];
                    else if (j == len2)
                        minRight = A[i];
                    else
                        minRight = min(A[i], B[j]);
                    return (maxLeft + minRight) / 2.0;
                }
            }
        }
        return 0.0;

    }

    public static void main(String[] args) {
        int A[] = { 2, 3 };
        int B[] = { 1 };
        System.out.println(new Median_of_Two_Sorted_Arrays_4()
                .findMedianSortedArrays(A, B));
    }
}
