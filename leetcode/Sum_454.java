package leetcode;
import java.util.HashMap;
import java.util.Map;

public class Sum_454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> sumOfAB = new HashMap<>();

        for (int a : A)
            for (int b : B)
                sumOfAB.put(a + b, sumOfAB.getOrDefault(a + b, 0) + 1);
        
        int res = 0;
        for(int c:C)
            for(int d:D)
                res += sumOfAB.getOrDefault(-(c+d), 0);
        return res;
    }

    public static void main(String[] args) {
        int A[] = {1,2};
        int B[] = {-2,-1};
        int C[] = {-1,2};
        int D[] = {0,2};
        System.out.println(new Sum_454().fourSumCount(A, B, C, D));
    }
}
