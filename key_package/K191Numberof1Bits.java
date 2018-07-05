package key_package;

public class K191Numberof1Bits {
    public int hammingWeight(int n) {
        String binary = Integer.toUnsignedString(n, 2);
        int res = 0;
        for (char c : binary.toCharArray()) {
            if (c == '1')
                res += 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toUnsignedLong(0xffffffff));
    }
}
