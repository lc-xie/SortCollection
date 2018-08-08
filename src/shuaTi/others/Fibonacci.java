package shuaTi.others;

/**
 * Created by stephen on 18-6-5.
 * 输出菲波拉契数列第n项
 */
public class Fibonacci {

    public static int fibonacci(int n){
        if (n<3)return 1;
        int l1=1;
        int l2=1;
        int cur=0;
        for (int i=3;i<=n;i++){
            cur=l1+l2;
            l1=l2;
            l2=cur;
        }
        return cur;
    }

}
