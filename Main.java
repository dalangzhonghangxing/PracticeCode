import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] printFormat = new String[10][5];
        printFormat[0][0] = "66666";
        printFormat[0][1] = "6...6";
        printFormat[0][2] = "6...6";
        printFormat[0][3] = "6...6";
        printFormat[0][4] = "66666";

        printFormat[1][0] = "....6";
        printFormat[1][1] = "....6";
        printFormat[1][2] = "....6";
        printFormat[1][3] = "....6";
        printFormat[1][4] = "....6";

        printFormat[2][0] = "66666";
        printFormat[2][1] = "....6";
        printFormat[2][2] = "66666";
        printFormat[2][3] = "6....";
        printFormat[2][4] = "66666";

        printFormat[3][0] = "66666";
        printFormat[3][1] = "....6";
        printFormat[3][2] = "66666";
        printFormat[3][3] = "....6";
        printFormat[3][4] = "66666";

        printFormat[4][0] = "6...6";
        printFormat[4][1] = "6...6";
        printFormat[4][2] = "66666";
        printFormat[4][3] = "....6";
        printFormat[4][4] = "....6";

        printFormat[5][0] = "66666";
        printFormat[5][1] = "6....";
        printFormat[5][2] = "66666";
        printFormat[5][3] = "....6";
        printFormat[5][4] = "66666";

        printFormat[6][0] = "66666";
        printFormat[6][1] = "6....";
        printFormat[6][2] = "66666";
        printFormat[6][3] = "6...6";
        printFormat[6][4] = "66666";

        printFormat[7][0] = "66666";
        printFormat[7][1] = "....6";
        printFormat[7][2] = "....6";
        printFormat[7][3] = "....6";
        printFormat[7][4] = "....6";

        printFormat[8][0] = "66666";
        printFormat[8][1] = "6...6";
        printFormat[8][2] = "66666";
        printFormat[8][3] = "6...6";
        printFormat[8][4] = "66666";

        printFormat[9][0] = "66666";
        printFormat[9][1] = "6...6";
        printFormat[9][2] = "66666";
        printFormat[9][3] = "....6";
        printFormat[9][4] = "66666";

        int n;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        String lines[] = new String[n];
        for (int i = 0; i < n; i++)
            lines[i] = sc.nextLine();

        String value;
        for (String line : lines) {
            value = String.valueOf(cal(line));
            print(value, printFormat);
        }
    }

    private static void print(String value, String[][] printFormat) {
        StringBuffer sb[] = new StringBuffer[5];
        sb[0] = new StringBuffer();
        sb[1] = new StringBuffer();
        sb[2] = new StringBuffer();
        sb[3] = new StringBuffer();
        sb[4] = new StringBuffer();
        for (int i = 0; i < value.length(); i++) {
            sb[0].append(printFormat[value.charAt(i) - '0'][0]).append("..");
            sb[1].append(printFormat[value.charAt(i) - '0'][1]).append("..");
            sb[2].append(printFormat[value.charAt(i) - '0'][2]).append("..");
            sb[3].append(printFormat[value.charAt(i) - '0'][3]).append("..");
            sb[4].append(printFormat[value.charAt(i) - '0'][4]).append("..");
        }
        System.out.println(sb[0].substring(0, sb[0].length() - 2));
        System.out.println(sb[1].substring(0, sb[1].length() - 2));
        System.out.println(sb[2].substring(0, sb[2].length() - 2));
        System.out.println(sb[3].substring(0, sb[3].length() - 2));
        System.out.println(sb[4].substring(0, sb[4].length() - 2));
    }

    private static long cal(String line) {
        List<Long> numbers = new ArrayList();
        List<Character> f = new ArrayList();
        StringBuffer number = new StringBuffer();
        Long l;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) >= '0' && line.charAt(i) <= '9') {
                number.append(line.charAt(i));
            } else {// 遇到符号
                l = Long.valueOf(number.toString());
                number.setLength(0);
                if (f.size() > 0 && f.get(f.size() - 1) == '*') {// 如果上一个符号是 *
                                                                 // ,先计算上面两个值的乘积
                    l = l * numbers.get(numbers.size() - 1);
                    numbers.remove(numbers.size() - 1);
                    f.remove(f.size() - 1);
                }
                numbers.add(l);
                f.add(line.charAt(i));
            }
        }

        // 计算倒数两个数字与一个符号的值
        l = Long.valueOf(number.toString());
        if (f.get(f.size() - 1) == '*') {// 如果上一个符号是 * ,先计算上面两个值的乘积
            l = l * numbers.get(numbers.size() - 1);
            numbers.remove(numbers.size() - 1);
            f.remove(f.size() - 1);
        }
        numbers.add(l);

        long res = numbers.get(0);
        for (int i = 0; i < f.size(); i++) {
            if (f.get(i) == '+') {
                res += numbers.get(i + 1);
            } else {
                res -= numbers.get(i + 1);
            }
        }
        return res;
    }
}
