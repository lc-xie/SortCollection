package shuaTi;

/**
 * Created by stephen on 18-5-23.
 * 字符串移位
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */
public class Test3 {
    public static String LeftRotateString(String str,int n) {
        if (str.length() == 0) {
            return str;
        }
        str += str;
        return str.substring(n % str.length(),n % str.length()+str.length()/2);
    }

    public static void main(String[] args){
        System.out.println(LeftRotateString("asfaDSADDS",4));
    }
}
