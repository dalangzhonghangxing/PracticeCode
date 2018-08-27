package 剑指offer;

public class 矩形覆盖 {
    public int RectCover(int target) {
        if(target<=3) return target;
        int ans[] = new int[target+1];
        ans[1] = 1;
        ans[2] = 2;
        ans[3] = 3;
        for(int i = 4;i<=target;i++)
            ans[i] = ans[i-1]+ans[i-2];
        return ans[target];
    }
}
