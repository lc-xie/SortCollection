package dp;

/**
 * Created by stephen on 18-4-23.
 *动态规划---硬币问题
 */
public class CoinDP {
    public static int[] coin=new int[]{5,4,6,3,7,8,23,12,9,10};//硬币数组
    public static int n=10;//硬币总数
    public static int[] d;//凑齐d[i]元所需硬币最少(多)数
    public static void main(String[] args){
        int S=18;//要凑的钱
        d=new int[S+1];
        d[0]=0;//凑0元需要0个硬币
        for (int i=1;i<=S;i++)d[i]=-1;//初始化为-1
        System.out.println(getMax(S));
    }

    //最少硬币
    public static void getMin(int S){
        //从状态d[1]开始,往上递推
        for (int i=1;i<=S;i++){
            int min=Integer.MAX_VALUE;
            for (int j=0;j<n;j++){
                if (i-coin[j]>=0)min=Math.min(1+d[i-coin[j]],min);
            }
            d[i]=min;
        }
        System.out.println(d[S]);
    }

    public static int getMax(int S){
        if (d[S]!=-1)return d[S];
        int max=Integer.MIN_VALUE;
        for (int j=0;j<n;j++){
            if (S-coin[j]>=0)max=Math.max(max,getMax(S-coin[j])+1);
        }
        return d[S]=max;
    }
}
