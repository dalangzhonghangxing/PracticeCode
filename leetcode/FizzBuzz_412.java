package leetcode;
import java.util.ArrayList;
import java.util.List;

public class FizzBuzz_412 {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            String one = "";
            boolean flag = false;
            if (i % 3 == 0) {
                one += "Fizz";
                flag = true;
            }
            if (i % 5 == 0) {
                one += "Buzz";
                flag = true;
            } 
            if(!flag)
                one += String.valueOf(i);
            res.add(one);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new FizzBuzz_412().fizzBuzz(15).toString());
    }
}
