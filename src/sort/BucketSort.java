package sort;

import java.util.Arrays;

/**
 * Created by stephen on 18-4-18.
 * ------------------------桶排序---------------------------
 * 方      式:将所有元素分组放入对应的桶中(计数排序),再进行桶内排序(插入排序),最后合并
 * 稳  定  性: 稳定
 * 时间复杂度: O(n)
 * 控件复杂度: O(n+dn)
 * 下面以[0,49]之间的值的排序为例
 */
public class BucketSort {
    final static int bn = 5;                 // 这里排序[0,49]的元素，使用5个桶就够了，也可以根据输入动态确定桶的数量
    static int[] C = new int[bn];        // 计数数组，存放桶的边界信息

    public static void main(String[] args) {
        int[] A = new int[]{3, 6, 12, 45, 32, 15, 18, 10, 20, 29, 38, 24, 30};
        bucketSort(A, 13);
        //sort.Tool.printArr(A);
    }

    /**
     * 桶排序
     *
     * @param A 排序数组
     * @param n 数组长度
     */
    public static void bucketSort(int[] A, int n) {
        countingSort(A, n);
        //对每个桶进行桶内排序
        for (int i = 0; i < bn; i++) {
            int left = (i == 0 ? 0 : C[i - 1]);
            int right = C[i] - 1;
            if (right > left) insertionSort(A, left, right);
            Tool.printArr(A);
        }
    }

    /**
     * 分桶,利用计数排序
     * 分桶后A的情况:3,6  12,15,18,10  20,29,24  32,38,30  45(稳定)
     *
     * @param A 目标数组
     * @param n 数组长度
     */
    public static void countingSort(int[] A, int n) {
        for (int a : A) {
            C[mapToBucket(a)]++;
        }
        for (int i = 1; i < bn; i++) {
            C[i] += C[i - 1];
        }
        int[] B = new int[n];
        int[] CC = Arrays.copyOfRange(C, 0, bn);
        for (int i = n - 1; i >= 0; i--) {
            B[--CC[mapToBucket(A[i])]] = A[i];
        }
        for (int i = 0; i < n; i++) {
            A[i] = B[i];
        }
        Tool.printArr(C);
    }

    /**
     * 对x分桶
     *
     * @param x 数组元素
     * @return 桶编号
     */
    public static int mapToBucket(int x) {
        return x / 10;//这里因为数据在区间[0,49],故除以10来取十位上的数进行分桶(0,1,2,3,4桶)
    }

    /**
     * 插入排序
     *
     * @param A
     * @param left
     * @param right
     */
    public static void insertionSort(int[] A, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int get = A[i];
            int j = i - 1;
            while (A[j] > get) {
                A[j + 1] = A[j--];
            }
            A[j + 1] = get;
        }
    }
}
