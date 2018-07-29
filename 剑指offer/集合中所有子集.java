
package 剑指offer;

/**
 * 首先计算总共有多少子集数量，然后使用位运算转成掩码获得子集。
 */
public class 集合中所有子集 {

    public void printSubSet(char[] set) {
        int max = (int) Math.pow(2, set.length) - 1;
        String mask;
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= max; i++) {
            mask = Integer.toBinaryString(i);
            sb.delete(0, sb.length());
            for (int j = mask.length() - 1; j >= 0; j--) {
                if (mask.charAt(j) == '1')
                    sb.append(set[mask.length()-1-j]);
            }
            System.out.println(sb.toString());
        }
    }


    public static void main(String[] args) {
        char[] set = {'a', 'b', 'c'};
        new 集合中所有子集().printSubSet(set);
    }
}
