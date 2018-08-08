package sort;

/**
 * Created by stephen on 18-4-16.
 * ------------------------堆排序---------------------------
 * 方      式:利用堆这种数据结构所设计的一种选择排序算法
 * 稳  定  性: 不稳定
 * 时间复杂度: O(nlogn),最差:O(nlogn),最优:O(nlogn)
 * 控件复杂度: O(1)
 */
/**
 * 堆排序
 * 将数组构建成堆后，不断将最大值和数组末尾值交换，再调整除末尾值外的堆
 * O(nlogn),不稳定
 */
public class HeapSort {

    public void heapSort(int[] arr,int n){
        //构建最大堆
        buildHeap(arr,n);
        //排序
        n--;
        while (n>0){
            swap(arr,0,n);
            heapify(arr,0,--n);
        }
    }

    public void buildHeap(int[] arr,int n){
        for (int i=n/2-1;i>=0;i--){
            heapify(arr,i,n-1);
        }
    }

    //调整
    public void heapify(int[] arr,int s,int e){
        int left_child = 2 * s + 1;         // 左孩子索引
        int right_child = 2 * s + 2;        // 右孩子索引
        int max = s;                        // 选出当前结点与其左右孩子三者之中的最大值
        if (left_child < e && arr[left_child] > arr[max])
            max = left_child;
        if (right_child < e && arr[right_child] > arr[max])
            max = right_child;
        if (max != s)
        {
            swap(arr, s, max);                // 把当前结点和它的最大(直接)子节点进行交换
            heapify(arr, max, e);          // 递归调用，继续从当前结点向下进行堆调整
        }
    }

    public void swap(int[] arr,int a,int b){
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

}