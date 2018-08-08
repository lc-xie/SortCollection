package dp;

/**
 * Created by stephen on 18-4-25.
 * 动态规划---台阶问题
 */
public class StepDP {
    public static void main(String[] args){
        int n=34;
        int[] dp=new int[n];
        dp[0]=1;
        dp[1]=2;
        for (int i=2;i<n;i++){
            dp[i]=dp[i-1]+dp[i-2];//状态转移方程
        }
        System.out.println(dp[3]);
    }
}
