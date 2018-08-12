package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {
    StringBuffer sb = new StringBuffer();

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        qpl(n, 0, 0, res);
        return res;
    }

    public void qpl(int left, int right, int index, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }

        if (right > 0) { // 如果能添加右括号
            sb.replace(index, index + 1, ")");
            qpl(left, right - 1, index + 1, res);
        }

        if (left > 0) { // 还能添加左括号
            sb.replace(index, index + 1, "(");
            qpl(left - 1, right + 1, index + 1, res);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses_22().generateParenthesis(3));
    }
}
