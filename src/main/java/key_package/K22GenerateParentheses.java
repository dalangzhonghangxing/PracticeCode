package key_package;

import java.util.ArrayList;
import java.util.List;

public class K22GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        int toAdd = 0, deep = 2 * n;
        StringBuilder sb = new StringBuilder();
        loop(res, deep, 0, n, 0, sb);
        return res;
    }

    private void loop(List<String> res, int deep, int toAdd, int canAdd,
            int currentDeep, StringBuilder sb) {
        if (deep == currentDeep) {
            res.add(sb.toString());
            return;
        }
        if (canAdd > 0) {
            loop(res, deep, toAdd + 1, canAdd - 1, currentDeep + 1,
                    sb.append("("));
            sb.setLength(sb.length() - 1);
        }
        if (toAdd > 0) {
            loop(res, deep, toAdd - 1, canAdd, currentDeep + 1, sb.append(")"));
            sb.setLength(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        new K22GenerateParentheses().generateParenthesis(3);
    }
}
