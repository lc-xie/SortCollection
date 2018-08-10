package sort;

/**
 * Created by stephen on 18-4-3.
 * 全局工具类
 */
public class Tool {
    /**
     * 打印数组元素
     *
     * @param arr 数组
     */
    public static void printArr(int[] arr) {
        System.out.print("out: ");
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    /**
     * 交换数组两个位置的值
     *
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}
