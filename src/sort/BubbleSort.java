package sort;

/**
 * Created by stephen on 18-4-3.
 * ------------------------冒泡排序---------------------------
 * 方      式: 不断将最大的数移动到最后
 * 稳  定  性: 稳定
 * 时间复杂读: O(n^2),最差:O(n^2),最优:O(n)
 */
public class BubbleSort {
    public static void main(String[] args){
        int [] arr=new int[]{2,4,1,7,5,8,9,3,0,6};
        int n=arr.length;
        for (int i=0;i<n-1;i++){
            for (int j=0;j<n-1-i;j++){
                if (arr[j]>arr[j+1]){
                    //交换
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            Tool.printArr(arr);
        }
    }

}
