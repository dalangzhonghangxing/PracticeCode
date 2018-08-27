package 笔试;

import java.net.SecureCacheResponse;
import java.util.Scanner;

public class 头条2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
    }

    public static int getAns(int n, String str) {
        if (str.length() == n)
            return 1;
        if (str.length() > n)
            return 0;
        int ans = 0;
        for (int i = 0; i <= 9; i++) {
            ans += getAns(n, str+i);
        }
        ans+= getAns(n,'('+str+')');
//        ans += getAns()
        return 0;
    }
}
