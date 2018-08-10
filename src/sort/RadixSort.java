package sort;

/**
 * Created by stephen on 18-4-17.
 * ------------------------基数排序---------------------------
 * 方      式:将所有待比较正整数统一为同样的数位长度，数位较短的数前面补零。
 * 然后，从最低位开始进行基数为10的计数排序，
 * 一直到最高位计数排序完后，数列就变成一个有序序列（利用了计数排序的稳定性）。
 * 稳  定  性: 稳定
 * 时间复杂度: O(n*dn)
 * 控件复杂度: O(n*dn)
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] A = new int[]{223, 434, 675, 267, 323, 424, 437, 809, 81, 220, 761, 434, 975};
        radixSort(A, 3);
        Tool.printArr(A);
    }

    public static void radixSort(int[] A, int dn) {
        for (int i = 1; i <= dn; i++) {
            countingSort(A, i);
        }
    }

    /**
     * 根据A的第d位数字,对A排序,使用计数排序
     *
     * @param A
     * @param d 第几位
     */
    public static void countingSort(int[] A, int d) {
        int[] C = new int[10];
        for (int a : A) {
            C[getDigit(a, d)]++;
        }
        for (int i = 1; i < 10; i++) {
            C[i] += C[i - 1];
        }
        int[] B = new int[A.length];
        for (int i = A.length - 1; i >= 0; i--) {
            B[--C[getDigit(A[i], d)]] = A[i];
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = B[i];
        }
    }

    /**
     * 获取整数n第d位的数字
     *
     * @param n
     * @param d
     * @return 数字
     */
    public static int getDigit(int n, int d) {
        return (int) ((n - n % (Math.pow(10, d - 1))) / (Math.pow(10, d - 1))) % 10;
    }
}
