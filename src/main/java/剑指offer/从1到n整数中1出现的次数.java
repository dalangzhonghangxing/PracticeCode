package 剑指offer;

import static java.lang.System.out;

public class 从1到n整数中1出现的次数 {
    public static long power10(int n) {
        int res = 1;
        for (int i = 0; i < n; i++) {
            res *= 10;
        }
        return res;
    }

    public static long getOneTimes(String str) {
        if (str == null || str.length() == 0 || str.charAt(0) < '0' || str.charAt(0) > '9')
            return 0;

        int first = str.charAt(0) - '0';

        if (str.length() == 1 && first == 0)
            return 0;
        if (str.length() == 1 && first == 1)
            return 1;

        // 只记录首位为1的数量，不包括其它位
        long firstcount = 0;
        if (first > 1) {// 以5位数来看，如果首位大于1，肯定有10000-19999这些数，即首位为1有10^4个。
            firstcount = power10(str.length() - 1);
        } else if (first == 1) {// 以5位数12345来看，如果首位等于1，肯定有10000-12345这些数字至少有一个1，即首位为1有2345+1
            firstcount = Long.parseLong(str.substring(1)) + 1;
        }

        // 记录其它位中，1的数量。
        // 以5位数62345来看，不考虑首位有4位数，通过固定其中一位为1，枚举其它3位有1000个1，共有4位即4000。但是首位可以从1-6，即6*4000个1
        long nonfirstcount = first * (str.length() - 1) * power10(str.length() - 2);

        // 然后递归计算下一个数量级，即首位为0的情况
        long zerocount = getOneTimes(str.substring(1));
        return firstcount + nonfirstcount + zerocount;
    }

    public static void main(String[] args) {
        out.println(getOneTimes(String.valueOf(1000000)));
    }
}
