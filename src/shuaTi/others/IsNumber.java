package shuaTi.others;

/**
 * Created by stephen on 18-6-1.
 * 判断一个字符串是不是数字
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class IsNumber {

    public static void main(String[] args){
        System.out.print(isNumeric("+0123.23400e-1.2".toCharArray()));
    }

    public static boolean isNumeric(char[] str) {
        String string=String.valueOf(str);
        if (string.contains("e")){
            String[] arr=string.split("e");
            if (arr.length!=2)return false;
            return isXiaoshu(arr[0])&&isZhengshu(arr[1]);
        }else if (string.contains("E")){
            String[] arr=string.split("E");
            if (arr.length!=2)return false;
            return isXiaoshu(arr[0])&&isZhengshu(arr[1]);
        }else {
            return isXiaoshu(string);
        }
    }
    //是不是整数
    public static boolean isZhengshu(String string){
        if (string.charAt(0)!='+'&&string.charAt(0)!='-'&&!isNum(string.charAt(0)))return false;
        for (int i=1;i<string.length();i++){
            if (!isNum(string.charAt(i)))return false;
        }
        return true;
    }
    //是不是小数
    public static boolean isXiaoshu(String string){
        if (isZhengshu(string))return true;
        if (!string.contains("."))return false;
        for (int i=0;i<string.length();i++){
            if (string.charAt(i)=='.'){
                return isZhengshu(string.substring(0,i))&&isZhengshu(string.substring(i+1));
            }
        }
        return false;
    }
    //字符是不是数字
    public static boolean isNum(char c){
        return c>47&&c<58;
    }
}
