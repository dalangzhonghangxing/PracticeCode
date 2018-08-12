package leetcode;

public class HammingDistance_461 {
    public static void main(String[] args) {
        System.out.println(new HammingDistance_461().hammingDistance(1,4));
    }

    public int hammingDistance(int x, int y) {
        int sum = 0;
        int gx,gy;
        while(x>0 || y>0){
            gx = get(x,0); 
            x = x>>1;
            gy = get(y,0); 
            y = y>>1;
            if(gx != gy) sum++;
        }
        return sum;
    }
    
    public int hammingDistance2(String l,String s){
        int sum = 0,i;
        for(i = 0;i<s.length();i++){
            if(l.charAt(i) != s.charAt(i))
                sum ++;
        }
        for(;i<l.length();i++)
            if(l.charAt(i) == '1')
                sum ++;
        return sum;
    }
    
    public int get(int num, int index)
    {
        return (num & (0x1 << index)) >> index;
    }
}
