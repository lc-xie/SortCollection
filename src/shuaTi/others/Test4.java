package shuaTi.others;

/**
 * Created by stephen on 18-5-24.
 * 单词反转
 */
public class Test4 {
    public static String ReverseSentence(String str) {
        if(str.length()<2){
            return str;
        }
        String[] arr=str.split(" ");
        String out=arr[0];
        for (int i=1;i<arr.length;i++){
            out=arr[i]+" "+out;
        }
        return out;
    }

    public static void main(String[] args){
        System.out.println(ReverseSentence(" "));
    }
}
