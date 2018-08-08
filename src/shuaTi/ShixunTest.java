package shuaTi;

import java.util.Arrays;

/**
 * Created by stephen on 18-6-19.
 * 实训测试
 */
public class ShixunTest {
    //判断奇偶，偶数返回true
    public static boolean isOddEven(int a){
        return a%2==0;
    }

    //判断大小写
    public static void isUpper(char input){
        if (input>=65&&input<=90){
            System.out.print("'"+input+"'是一个大写字母！");
        }else if (input>=97&&input<=122){
            System.out.print("'"+input+"'是一个小写字母！");
        }else {
            System.out.print("'"+input+"'不是英文字母！");
        }
    }
    //求1-99所有奇数和
    public static int qiuhe(){
        int n=1;
        int out=0;
        while (n<100&&isOddEven(n)){
            out+=n++;
        }
        return out;
    }
    //输入三个整数，输出最大数和最小数
    public static void getMaxAndMin(int[] arr){
        if (arr.length!=3){
            System.out.println("输入有误！");
        }else {
            Arrays.sort(arr);
            System.out.println("最大值："+arr[2]+"\n最小值："+arr[0]);
        }
    }
    //输入三个数排序，小到大
    public static void sort(int[] arr){
        Arrays.sort(arr);
        System.out.println(arr[0]+"<"+arr[1]+"<"+arr[2]);
    }
    //求1-200末尾为5的数的和
    public static int qiuhe2(){
        int n=5;
        int out=0;
        while (n<200){
            out+=n;
            n+=10;
        }
        return out;
    }
    //2.5的三次方
    public static double pow1(){
        return Math.pow(2.5,3);
    }
    //24的所有因子的积
    public static int test1(){
        int out=1;
        for (int i=1;i<=24;i++){
            if (24%i==0){
                out*=i;
            }
        }
        return out;
    }
    //转换大小写
    public static void changeUpperLower(String input){
        char[] arr=input.toCharArray();
        for (int i=0;i<arr.length;i++){
            if (arr[i]>=65&&arr[i]<=90){
                arr[i]=(char) (arr[i]+32);
            }else if (arr[i]>=97&&arr[i]<=122){
                arr[i]=(char) (arr[i]-32);
            }
        }
        System.out.println("转换后的字符串："+String.valueOf(arr));
    }

    //判断是否为素数
    public static boolean primeNumber(int input){
        for (int i=1;i<=Math.sqrt(input);i++){
            if (input%i==0)return false;
        }
        return true;
    }

    //水仙花数
    public static boolean shuiXianHua(int input){
        int a,b,c;
        a=input%10;
        b=(input-a)%10;
        c=input/100;
        return Math.pow(a,3)+Math.pow(c,3)+Math.pow(b,3)==input;
    }

    //圆周长和面积,输入直径
    public static void circle(double radius){
        System.out.println("周长："+radius*Math.PI+"\n面积："+radius*radius*Math.PI/4);
    }

    //三和五整除
    public static boolean test2(int input){
        return input%3==0&&input%5==0;
    }

    //方程求根
    public static void qiugen(float a,float b,float c){
         double rootOne;
         double rootTwo;
         double judge = (float) (Math.pow(b, 2)-(4*a*c));       //b^2-4ac
        rootOne=(-(b)+Math.sqrt(Math.abs(judge)))/(2*a);
        rootTwo=(-(b)-Math.sqrt(Math.abs(judge)))/(2*a);
        if (judge>0){
            System.out.println("第一个根："+rootOne);
            System.out.println("第二个根："+rootTwo);
        }else if (judge==0){
            System.out.println("只有一个根："+rootOne);
        }else {
            judge=-judge;
            System.out.println("第一个根："+(-b/(2*a)+Math.sqrt(-judge)+"i"));
            System.out.println("第二个根："+(-b/(2*a)-Math.sqrt(-judge)+"i"));
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] arr){
        if (arr==null)return;
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length-i-1;j++){
                if (arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        for (int a:arr){
            System.out.print(a+" ");
        }
    }
}
