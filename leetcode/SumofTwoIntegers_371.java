package leetcode;

public class SumofTwoIntegers_371 {
    public int getSum(int a, int b) {
        return ((a&b)<<1) == 0 ? a^b : getSum((a&b)<<1,a^b);
    }
    
}
