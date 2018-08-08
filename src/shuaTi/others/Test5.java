package shuaTi.others;

/**
 * Created by stephen on 18-6-7.
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Test5 {

    public static void main(String[] args){
        System.out.print(numberOf1(92));
    }

    public static int numberOf1(int n) {
        if (n==0)return 0;
        if (n>0)return cal(n);
        //n为负数时，补码为数据位取反加一，这里用111111111111111-|n|相当于取反
        return cal(Integer.MAX_VALUE+n+1)+1;
    }
    //计算正数的1的个数
    public static int cal(int n){
        int out=0;
        if (n>0){
            for (int i=1;i<32;i++){
                int mod=(int)(n%Math.pow(2,i));
                if (mod>0) {
                    out += mod / Math.pow(2, i - 1);
                }
            }
        }
        return out;
    }

}
