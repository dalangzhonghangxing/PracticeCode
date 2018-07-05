package interview;

public class Pool {

    // 随机生成资金的范围在0-MAX_P
    private final static int MAX_P = 100;

    // preAllocationShotfalls
    int[] pre;

    // afterAllocationShotfalls
    int[] after;

    int[] allocate;

    int length;

    /**
     * 初始化资金池
     * 
     * @param poolNumber
     *            资金池数量
     * @throws Exception
     */
    public void init(int poolNumber) throws Exception {
        if (poolNumber <= 0) throw new Exception("资金池数量必须大于0！");
        pre = new int[poolNumber];
        after = new int[poolNumber];
        allocate = new int[poolNumber];
        length = poolNumber;
        for (int i = 0; i < length; i++) {
            pre[i] = (int) (Math.random() * MAX_P);
        }
    }

    /**
     * 支出数量为money的资金，并使得资金池之间差额达到最小。 差额总值的计算方式为：计算任意两个资金池的差的绝对值，并相加 具体流程如下： 1.
     * 找出资金数量最小的资金池m 2. 计算目前资金池之间的差额o_diff 3.
     * 如果money>=o_diff，则分配后每个资金池的资金数为(m-floor((money-o_diff)/length))，再支出少减的资金
     * 4. 如果money<o_diff，则对所有资金池按照
     * 
     * @param money
     *            待支出资金
     */
    public void allocate(int money) {

    }

    /**
     * 计算所有资金池之间的差额
     * 
     * @param array
     *            待计算数组
     * @return
     */
    public int diff(int array[]) {
        int sum = 0;
        for (int i = 0; i < array.length; i++)
            for (int j = i + 1; j < array.length; j++)
                sum += Math.abs(array[i] - array[j]);
        System.out.println(sum);
        return sum;
    }

    /**
     * 打印出分配后的资金池信息
     */
    public void print() {
        for (int i = 0; i < length; i++)
            System.out.println(String.format(
                    "AllocationSupplyResult [fundPoolId=?1, preAllocationShotfalls=?2, allocationShotfalls=?3, afterAllocationShotfalls=?4]",
                    i, pre[i], allocate[i], after[i]));

    }

    public static void main(String[] args) {
        int[] array = { 46, 46, 46, 46, 47, 50, 44, 41, 38, 4 };
        new Pool().diff(array);
        int[] array2 = { 46, 47, 47, 47, 47, 47, 44, 41, 38, 4 };
        new Pool().diff(array2);
    }
}
