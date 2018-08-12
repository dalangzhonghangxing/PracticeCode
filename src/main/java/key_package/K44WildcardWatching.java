package key_package;

public class K44WildcardWatching {
    public boolean isMatch(String s, String p) {
        int ps = 0, pp = 0, starIndex = -1, match = -1;
        while (ps < s.length()) {
            if (pp < p.length() && p.charAt(pp) == '*') { // 如果匹配到*，先记录下匹配的到位置，为了回溯
                match = ps;
                starIndex = pp++;
            } else if (pp < p.length()
                    && (p.charAt(pp) == s.charAt(ps) || p.charAt(pp) == '?')) {// p与s相等，或p为？,同时++
                pp++;
                ps++;
            } else if (starIndex >= 0) {// p既不是*，也与s不等，则会退到上次*的位置
                ps = ++match;
                pp = starIndex + 1;
            } else// 如果*也没有，则匹配失败
                return false;
        }
        while (pp < p.length() && p.charAt(pp) == '*')// 如果p还剩下，都为*则返回true，否则返回false
            pp++;
        return pp == p.length();
    }
}