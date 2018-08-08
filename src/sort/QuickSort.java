package sort;

/**
 * Created by stephen on 18-4-16.
 *------------------------快速排序---------------------------
 * 方      式:使用分治策略来把一个序列分为两个子序列:以最后一个数为基准,正序遍历数组,
 *           将比基准小的数往前放,大的往后放,最后将基准插入到中间位置,并返回基准的位置
 *           根据返回的基准的下标,将数组分成了两个字数组,左边的数组都比基准小,右边的都大
 *           分治对两个字数组快排
 * 稳  定  性: 不稳定
 * 时间复杂度: O(n log n),最差:O(n^2),最优:O(n log n)
 * 控件复杂度: O(log n)
 * 注:
 *      java中的Arrays.sort()对于基础类使用快排,因为基础类对稳定性没有要求
 *      对于非基础类,使用归并排序,非基础类要求稳定性
 */
public class QuickSort {
    public static void main(String[] args){
        int[] arr = new int[]{2, 4, 1, 7, 5, 8, 9, 3, 0, 6};
        quickSort(arr,0,9);
    }

    public static void quickSort(int[] aimArr,int left,int right){
        Tool.printArr(aimArr);
        if (left>=right)return;
        int p=partition(aimArr,left,right);
        quickSort(aimArr,left,p-1);
        quickSort(aimArr,p+1,right);
    }

    /**
     * 对一段数组进行排序
     * 以最后以为(right)为基准,比它小的往前放
     * 开始i=0,有一个aimArr[j]<=pivot时,swap(i,j)
     * 同时i++,这样将小于基准的数都移到数组前面
     * 最后swap(i,right)
     */
    public static int partition(int[] aimArr,int left,int right){
        int pivot=aimArr[right];
        int i=left;
        for (int j=left;j<right;j++){
            if (aimArr[j]<=pivot){
                swap(aimArr,i++,j);
            }
        }
        swap(aimArr,i,right);
        Tool.printArr(aimArr);
        return i;
    }
    //交换
    public static void swap(int[] aimArr,int i,int j ){
        int temp=aimArr[i];
        aimArr[i]=aimArr[j];
        aimArr[j]=temp;
    }
}
