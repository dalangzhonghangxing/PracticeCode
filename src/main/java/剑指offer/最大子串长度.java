package 剑指offer;

import static java.lang.System.out;

/**
 * 构建一个长度为26的数组，来记录在当前窗口已经出现的字符串。
 * 定义指针l,r最为窗口左右边界，如果第r+1个字符x出现过，那就让l走到上一个x出现的下一个位置。
 */
public class 最大子串长度 {
    public static void main(String[] args) {
        getMaxLenSubStr("pwwkew");
    }

    public static void getMaxLenSubStr(String str) {
        boolean s[] = new boolean[26];
        int l = 0, r = 0;
        s[str.charAt(0) - 'a'] = true;
        int ans = 1;
        while (++r < str.length()) {
            if (s[str.charAt(r) - 'a']) {//出现过
                while (str.charAt(l) != str.charAt(r)) {
                    s[str.charAt(l) - 'a'] = false;
                    l++;
                }
                l++;
            } else {
                ans = Math.max(ans, r - l + 1);
                s[str.charAt(r) - 'a'] = true;
            }
        }
        out.println(ans);
    }
}
