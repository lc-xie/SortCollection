package sort;

/**
 * Created by stephen on 18-4-3.
 * ------------------------选择排序---------------------------
 * 方      式: 每次遍历选出最小值,遍历完之后将其放到最前面的位置
 * 稳  定  性: 选择排序是不稳定的排序算法，不稳定发生在最小元素与A[i]交换的时刻
 * 时间复杂读: O(n^2),最差:O(n^2),最优:O(n^2)
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 1, 7, 5, 8, 9, 3, 0, 6};
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;//当前最小元素的位置
            for (int j = i + 1; j < n; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            //交换
            if (i != min) {
                Tool.swap(arr, min, i);
            }
            //Tool.printArr(arr);
        }
        Tool.printArr(arr);
    }

}
