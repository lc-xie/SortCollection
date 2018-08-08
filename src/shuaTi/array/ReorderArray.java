package shuaTi.array;

/**
 * Created by stephen on 18-6-8.
 * 将数组中奇数放左边，偶数放右边，保证顺序不变
 */
public class ReorderArray {
    public static void main(String[] args){
        int[] arr=new int[]{1,2,3,4,5,6,7};
        reOrderArray(arr);

    }

    /**
     * 法一：遍历，找到奇数则一步一步往前移
     */
    public static void reOrderArray(int [] array) {
        for (int i=1;i<array.length;i++){
            if (array[i]%2!=0){
                int j=i-1;
                int lable=i;
                while (j>=0&&array[j]%2==0){
                    exchange(array,lable--,j--);
                }
            }
        }
    }

    /*
     * 法二，辅助数组
     */

    public static void exchange(int[] array,int i,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}
