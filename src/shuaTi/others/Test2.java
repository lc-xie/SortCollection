package shuaTi.others;

import java.util.ArrayList;

/**
 * Created by stephen on 18-5-22.
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * https://www.nowcoder.com/practice/390da4f7a00f44bea7c2f3d19491311b?tpId=13&tqId=11195&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Test2 {

    public static void main(String[] args){
        int[] arr=new int[]{1,2,3,5,7,9,12,23};
        ArrayList<Integer> arrayList=findNumbersWithSum(arr,10);
        System.out.println(arrayList.get(0)+"   "+arrayList.get(1));
    }

    /**
     * 头部和尾部各设置一个指针，判断两边的值的和是否等于sum，
     * 相等则直接输出，>sum则尾部指针往前移，<sum则头部指针向后移
     * @param array 递增数组
     * @param sum 目标数字
     */
    public static ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> outArray =new ArrayList<>();
        if (array[0]+array[array.length-1]<sum || array.length<2)return outArray;
        int left=0;
        int right=array.length-1;
        while (left<right){
            if (array[left]+array[right]==sum){
                outArray.clear();
                outArray.add(array[left]);
                outArray.add(array[right]);
                left++;
                right--;
            }else if (array[left]+array[right]>sum){
                right--;
            }else if (array[left]+array[right]<sum){
                left++;
            }
        }
        return outArray;
    }

    /*public ArrayList<Integer> dpLeft(int[] array,int left,int right){

    }*/
}
