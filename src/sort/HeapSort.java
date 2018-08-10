package sort;

import static sort.Tool.swap;

/**
 * Created by stephen on 18-8-9.
 * ------------------------堆排序---------------------------
 * 方      式:将数组构建成堆后，不断将最大值和数组末尾值交换，再调整除末尾值外的堆
 * 这里构建堆的过程不太好理解，是直接在数组上进行的堆调整
 * 稳  定  性: 不稳定
 * 时间复杂度: O(nlogn),最差:O(nlogn),最优:O(nlogn)
 * 控件复杂度: O(1)
 */

public class HeapSort {

    public static void heapSort(int[] arr, int n) {
        //构建最大堆
        buildHeap(arr, n);
        //排序,不断将最大值(堆顶元素)和数组末尾值交换，再调整除末尾值外的堆
        n--;
        while (n > 0) {
            swap(arr, 0, n);
            heapify(arr, 0, --n);
        }
    }

    public static void buildHeap(int[] arr, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n - 1);
            //Tool.printArr(arr);
        }
    }

    //遍历所有有子节点的节点，自顶向下调整
    public static void heapify(int[] arr, int s, int e) {
        int left_child = 2 * s + 1;         // 左孩子索引
        int right_child = 2 * s + 2;        // 右孩子索引
        int max = s;                        // 选出当前结点与其左右孩子三者之中的最大值
        if (left_child <= e && arr[left_child] > arr[max])
            max = left_child;
        if (right_child <= e && arr[right_child] > arr[max])
            max = right_child;
        if (max != s) {
            swap(arr, s, max);                // 把当前结点和它的最大(直接)子节点进行交换
            heapify(arr, max, e);          // 递归调用，继续从当前结点向下进行堆调整
        }
    }

    public static void main(String[] args) {
        int[] inputArr = new int[]{8, 1, 2, 5, 0, 3, 9, 4, 6, 7};
        heapSort(inputArr, 10);
        Tool.printArr(inputArr);
    }

}