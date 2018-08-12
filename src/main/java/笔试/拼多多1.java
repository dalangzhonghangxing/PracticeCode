package 笔试;

import java.util.Scanner;

public class 拼多多1 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int tmp = 4;
        while(true){
            if(n - tmp <= 0){
                break;
            }
            n -= tmp;
            tmp *= 2;
        }
        if(n != 0){
            int num = tmp / 4;

            if(n % num == 0)    n = n / num -1;
            else    n = n / num;
            if(n == 0)  System.out.println("Alice");
            if(n == 1)  System.out.println("Bob");
            if(n == 2)  System.out.println("Cathy");
            if(n == 3)  System.out.println("Dave");
        }else{
            System.out.println("Dave");
        }
    }
}
