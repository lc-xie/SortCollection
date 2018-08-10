package sort;

/**
 * Created by stephen on 18-4-17.
 * ------------------------计数排序---------------------------
 * 方      式:1.统计数组A中每个值A[i]出现的次数，存入C[A[i]]
 * 2.从前向后，使数组C中的每个值等于其与前一项相加，这样数组C[A[i]]就变成了
 * 代表数组A中小于等于A[i]的元素个数
 * 3.反向填充目标数组B：将数组元素A[i]放在数组B的第C[A[i]]个位置（下标为C[A[i]] - 1），
 * 每放一个元素就将C[A[i]]递减
 * 稳  定  性: 稳定
 * 时间复杂度: O(n+max)
 * 控件复杂度: O(n+max)
 */
public class CountingSort {

    public static void main(String[] args) {
        int[] A = new int[]{2, 4, 6, 2, 3, 4, 7, 9, 1, 0, 1, 4, 5};
        countingSort(A, 9);
        Tool.printArr(A);
    }

    /**
     * 计数排序
     *
     * @param A   数组
     * @param max 数组中最大值
     */
    public static void countingSort(int[] A, int max) {
        int[] C = new int[max + 1];
        for (int a : A) {
            C[a]++;
        }
        for (int i = 1; i < max + 1; i++) {
            C[i] += C[i - 1];
        }
        int[] B = new int[A.length];
        for (int i = A.length - 1; i >= 0; i--) {
            B[--C[A[i]]] = A[i];
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = B[i];
        }
    }
}
