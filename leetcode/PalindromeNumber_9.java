package leetcode;

public class PalindromeNumber_9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int y = 0;
        int z = x;
        while (z > 0) {
            y = y * 10 + z % 10;
            z /= 10;
        }
        if (x == y) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeNumber_9().isPalindrome(122));
    }
}
