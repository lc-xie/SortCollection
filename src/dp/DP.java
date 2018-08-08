package dp;

/**
 * Created by stephen on 18-4-22.
 * 动态规划---嵌套矩形
 */
public class DP {
    //从节点i出发的最长路径
    private static int[] d=new int[]{0,0,0,0,0,0,0,0,0,0};
    //节点数
    private static int n=10;
    //矩形节点
    private static int[][] input=new int[][]{{1,2},{3,4},{2,5},{4,1},{5,8},{8,6},
            {7,9},{12,17},{8,19},{4,6}};

    public static void main(String[] args){
        System.out.println(DAG1(0));
    }

    /**
     * 嵌套矩形
     */
    public static int DAG1(int i){
        int cur=d[i];//从编号为i的节点出发,最长路径
        if (cur>0)return cur;
        cur=1;
        for (int j=0;j<n;j++){
            //若当前矩形(j)可以嵌套i,则比较大小
            if (check(i,j)) cur=Math.max(cur,DAG1(j)+1);
        }
        return cur;
    }

    /**
     * j能否嵌套i,即判断边长
     */
    public static boolean check(int i,int j){
        if (Math.min(input[i][0],input[i][1])<Math.min(input[j][0],input[j][1])&&
                Math.max(input[i][0],input[i][1])<Math.max(input[j][0],input[j][1])){
            return true;
        }
        return false;
    }
}
