import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<String> ans = qpl(m, n);
        Collections.sort(ans);
        if (k > ans.size()) {
            System.out.println(-1);
        } else {
            System.out.println(ans.get(k - 1));
        }
    }

    public static List<String> qpl(int m, int n) {
        List<String> ans = new ArrayList<>();
        getqpl(m, n, "", ans);
        return ans;
    }

    public static void getqpl(int l, int r, String str, List<String> ans) {
        if (l < 0 || r < 0)
            return;
        if (l == 0 && r == 0) {
            ans.add(str);
            str = "";
        }
        getqpl(l - 1, r, str + "a", ans);
        getqpl(l, r - 1, str + "z", ans);
    }
}
