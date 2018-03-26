package leetcode;
import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_Without_Repeating_Characters_3 {

    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> lastIndex = new HashMap<>();
        char[] cs = s.toCharArray();
        int begin = 0;
        int max = 0;

        for (int i = 0; i < cs.length; i++) {
            if (lastIndex.get(cs[i]) == null) {
                lastIndex.put(cs[i],i);
            } else {
                if(begin<lastIndex.get(cs[i]) + 1)
                    begin = lastIndex.get(cs[i]) + 1;
                lastIndex.put(cs[i],i);
            }
            if (max < i - begin + 1) max = i - begin + 1;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out
                .println(new Longest_Substring_Without_Repeating_Characters_3()
                        .lengthOfLongestSubstring("abba"));
    }
}
