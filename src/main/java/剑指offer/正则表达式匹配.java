package 剑指offer;

public class 正则表达式匹配 {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) return false;

        return matchCore(str, pattern, 0, 0);
    }

    public boolean matchCore(char[] str, char[] pattern, int i, int j) {
        // 完全匹配
        if (i == str.length && j == pattern.length) return true;
        
        // pattern已经到最后了，但是str还剩下
        if (i < str.length && j >= pattern.length) return false;
        
        // pattern的下一个字符是*，分为两种情况
        if (j + 1 <pattern.length && pattern[j + 1] == '*') {
            // 当前是匹配的，则尝试一下3中情况
            // 1. str走一个，pattern不动，即重复匹配
            // 2. str走一个，pattern往下走，由于要跳过*，走2，即str的下一个与x*不匹配了
            // 3. str不动，pattern走2，即当前*为0的情况
            if (i < str.length && pattern[j] == str[i] || (pattern[j] == '.' && i != str.length)) {
                return matchCore(str, pattern, i + 1, j)
                        || matchCore(str, pattern, i + 1, j + 2)
                        || matchCore(str, pattern, i, j + 2);
            } else {//当前没有匹配，则pattern往下继续
                return matchCore(str, pattern, i, j + 2);
            }
        }
        // 如果当前匹配，str与pattern都走1
        if ((i < str.length && pattern[j] == str[i])
                || (pattern[j] == '.' && i != str.length)) { return matchCore(
                        str, pattern, i + 1, j + 1); }
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(new 正则表达式匹配().match("".toCharArray(),".".toCharArray()));
    }
}
