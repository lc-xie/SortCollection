package shuaTi.others;

/**
 * Created by stephen on 18-5-27.
 * 将一个字符串转换成数字
 * 若不是合法的数字字符串则返回零
 */
public class StrToNumber {
    public static void main(String[] args){
        System.out.print(StrToInt("-2147483648"));
    }

    public static int StrToInt(String str) {
        if (str==null||str.equals(""))return 0;
        int len=str.length();
        long out=0;
        int k=0;//位数
        for (int i=len-1;i>=0;i--){
            if (str.charAt(i)>47&&str.charAt(i)<58){
                out+=(str.charAt(i)-48)*Math.pow(10,k);
                k++;
            }else if (i==0){
                if (str.charAt(i)=='+'){
                    return (int) out;
                }else if (str.charAt(i)=='-'){
                    return (int) (out-out-out);
                }else {
                    return 0;
                }
            }else {
                return 0;
            }
        }
        return (int) out;
    }
}
