package 剑指offer;

public class 翻转单词顺序列 {
    public String ReverseSentence(String str) {
        if (str == null || str.trim().equals("")) return str;
        String[] words = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i] + " ");
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(new 翻转单词顺序列().ReverseSentence(" "));
    }
}
