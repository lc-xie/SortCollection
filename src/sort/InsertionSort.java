package sort;

/**
 * Created by stephen on 18-4-3.
 * ---------- 插入排序-----------
 * 直接插入排序,二分插入排序,希尔排序
 */
public class InsertionSort {
    /**
     * ------------------------ 直接插入排序---------------------------
     * 方      式: 从数组下标1处开始向后遍历,每次将当下位置的数插入到该下标之前已经排好序的数组中恰当的位置
     *             即每次get一个数后,遍历该数下标前面的数组,往回倒序遍历,比get大则将该数往后移,直到比get小,
     *             再将get放入比它小的那个数前一位
     *             概述:将第i个数插入到它前面的已经排好的数组中
     * 稳  定  性: 插入排序是稳定的
     * 时间复杂读: O(n^2),最差时,即数组是倒序的:O(n^2),最优:时,即数组是正序的:O(n)
     */
    public static void insertSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int current=arr[i];
            int j=i-1;
            while (j>=0&&current<arr[j]){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=current;
            Tool.printArr(arr);
        }
    }

    /**
     * ------------------------二分(折半)插入排序---------------------------
     * 方      式: 原理同插入排序,在寻找插入位置时.使用二分查找法,而不是倒序遍历
     * 稳  定  性: 稳定
     * 时间复杂读: O(n^2),最差:O(n^2),最优:O(n log(n))
     * n较大时,二分插入排序的比较次数比直接插入排序的最差情况好的多,比最好情况差
     * 二分插入排序的对象移动次数与直接插入排序相同
     */
    public static void insertionSortDichotomy(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int current=arr[i];
            //下面用二分查找法寻找插入位置
            int left=0;
            int right=i-1;
            while (left<=right){
                int mid=(right+left)/2;
                if (arr[mid]<current){
                    left=mid+1;
                }else {
                    right=mid-1;
                }
            }
            //移动数据,将current插入到合适位置
            for (int j=i-1;j>=left;j--){
                arr[j+1]=arr[j];
            }
            arr[left]=current;
            Tool.printArr(arr);
        }
    }
    /**
     * ------------------------插入排序改进:希尔排序---------------------------
     * 方      式: 通过将比较的全部元素分为几个区域来提升插入排序的性能,
     *            这样可以让一个元素可以一次性地朝最终位置前进一大步
     * 稳  定  性: 不稳定
     * 时间复杂读: 由不同的步长决定,最差:由步长决定,最优:O(n)
     *
     * 希尔排序是基于插入排序的以下两点性质而提出改进方法的：
     *  1.插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率
     *  2.但插入排序一般来说是低效的，因为插入排序每次只能将数据移动一位
     */
    public static void sheelSort(int[] arr){
        int h=0;
        while (h<=arr.length){
            h=3*h+1;
        }
        while (h>0){
            System.out.println(h);
            //对于每一个增量h,进行一次全局的插入排序
            for (int i=h;i<arr.length;i++){
                int j=i-h;
                int get=arr[i];
                while (j>=0&&get<arr[j]){
                    arr[j+h]=arr[j];
                    j=j-h;
                }
                arr[j+h]=get;
            }
            h=(h-1)/3;
            Tool.printArr(arr);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 1, 7, 5, 8, 9, 3, 0, 6};
        insertSort(arr);
        insertionSortDichotomy(arr);
        sheelSort(arr);
    }
}
