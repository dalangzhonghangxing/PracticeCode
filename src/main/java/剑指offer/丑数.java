package 剑指offer;

public class 丑数 {
    public int GetUglyNumber_Solution(int index) {
        if (index < 7) return index;
        int[] records = new int[index];
        int x = 0, y = 0, z = 0, k = 1, min;
        records[0] = 1;
        while (index > 1) {
            min = Math.min(Math.min(records[x] * 2, records[y] * 3), records[z] * 5);
            records[k++] = min;
            if (min == records[x] * 2)
                x++;
            if (min == records[y] * 3)
                y++;
            if (min == records[z] * 5)
                z++;
            index--;
        }
        return records[records.length - 1];
    }

    public static void main(String[] args) {
        new 丑数().GetUglyNumber_Solution(10);

    }
}
