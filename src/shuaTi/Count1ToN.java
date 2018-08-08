package shuaTi;

/**
 * Created by stephen on 18-5-26.
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Count1ToN {

    public static void main(String[] args){

    }

    //递归，加一个temp>0的判断
    public static int method1(int n){
        int temp=n;
        boolean b=(temp>0)&&((temp+=method1(temp-1))>0);
        return temp;
    }

    //利用公式n(n+1)/2,这里n(n+1)可以用数组[n][n-1]的长度来算，最后移位除2
    public static int method2(int n){
        boolean[][] booleans=new boolean[n][n-1];
        return booleans.length;
    }

}
