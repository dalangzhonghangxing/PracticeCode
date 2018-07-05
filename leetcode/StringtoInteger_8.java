/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package leetcode;

/**
 * 1. 去除开头空格
 * 2. 判断首位是不是符号或数字，如果不是，返回0
 * 3. 如果首位是符号，记录符号位，并移除该位;并判断最新的首位是否是数字，如果不是，返回0
 * 4. 如果首位是数字，找下一个不是0的数字。如果下一个非0字符不是数字，返回0
 * 5. 如果下一个是非0数字，则找下一个非数字的数，截取数字str，转成BigInteger
 * 6. 比较BigInteger与Integer.max的大小，如果比max大，返回max，否则返回BigInteger.integer
 */
public class StringtoInteger_8 {
    public int myAtoi(String str) {
        //1
        int s = 0;
        for (; s < str.length() && str.charAt(s) == ' '; s++) ;
        if (s >= str.length()) return 0;

        //2
        if (str.charAt(s) != '-' && str.charAt(s) != '+' && !Character.isDigit(str.charAt(s)))
            return 0;

        //3
        boolean positive = true;
        if (str.charAt(s) == '-') {
            positive = false;
            s++;
        } else if (str.charAt(s) == '+') {
            s++;
        }

        if (s >= str.length() || !Character.isDigit(str.charAt(s))) return 0;

        //4
        for (; s < str.length() && str.charAt(s) == '0'; s++) ;
        if (s >= str.length() || !Character.isDigit(str.charAt(s))) return 0;

        //5
        int e = s;
        for (; e < str.length() && Character.isDigit(str.charAt(e)); e++) ;

        // 如果长度超过11位，那肯定超长
        if (e - s >= 11) {
            if (positive)
                return Integer.MAX_VALUE;
            else
                return Integer.MIN_VALUE;
        }

        long value = 0;
        for (; s < e; s++) {
            value = value * 10 + str.charAt(s) - '0';
            if (value >= Integer.MAX_VALUE)
                break;
        }
        if (positive) {
            if (value >= 0x7fffffffl) return Integer.MAX_VALUE;
            else return (int) value;
        } else {
            if (value >= 0x7fffffffl + 1) return Integer.MIN_VALUE;
            else return -(int) value;
        }
    }

    public static void main(String[] avgs) {
        System.out.println(new StringtoInteger_8().myAtoi("-2147483649"));

    }
}
