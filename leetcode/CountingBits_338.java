package leetcode;

public class CountingBits_338 {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        if (num == 0) {
            ans[0] = 0;
            return ans;
        }
        if (num == 1) {
            ans[0] = 0;
            ans[1] = 1;
            return ans;
        }
        ans[0] = 0;
        ans[1] = 1;
        int k = 1;
        for (int i = 2; i <= num; i += k) {
            k = k << 1;
            for (int j = 0; j < k && i + j <= num; j++) {
                ans[i + j] = 1 + ans[j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        for (int i : new CountingBits_338().countBits(5)) {
//            System.out.println(i);
//        }
        System.out.println(16>>>1);
    }
}
