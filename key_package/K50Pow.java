package key_package;

public class K50Pow {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == Integer.MIN_VALUE) {
            n /= 2;
            x *= x;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return (n % 2 == 0) ? Math.pow(x * x, n / 2) : x * Math.pow(x * x, n / 2);

    }

    public static void main(String[] args) {
        double x = 2;
        int p = 7;
        System.out.println(new K50Pow().myPow(x, p));
        System.out.println(Math.pow(x, p));
    }
}
