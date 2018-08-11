package com.anbow.java2.test2015.wzy05.first;

import java.util.Arrays;
import java.util.Scanner;

public class WangYi {

    public static void main(String[] args) {
        fun();
    }

    public static void fun() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mostOpration = sc.nextInt();
        int[][] heigh = new int[n][2];
        for (int i = 0; i < n; i++) {
            heigh[i][0] = i + 1;
            heigh[i][1] = sc.nextInt();
        }
        if (n == 1) {
            System.out.println(0 + " " + 0);
        }
        quickSort(heigh, 0, n-1);
        int actualOperation = 0;
        int[] log = new int[2 * mostOpration];
        while (heigh[0][1] < heigh[n-1][1] - 2 && actualOperation < mostOpration) {
            heigh[n - 1][1]--;
            heigh[0][1]++;
            log[actualOperation * 2] = heigh[n - 1][0];
            log[actualOperation * 2 +1] = heigh[0][0];
            actualOperation++;
            if (heigh[0][1] > heigh[1][1])swap(heigh, 0, 1);
            if (heigh[n - 1][1] < heigh[n - 2][1])swap(heigh, 0, 1);
        }
        if (actualOperation < mostOpration) {
            if (heigh[0][1] != heigh[1][1] || heigh[n-1][1] != heigh[n-2][1]) {
                heigh[n - 1][1]--;
                heigh[0][1]++;
                log[actualOperation * 2] = heigh[n - 1][0];
                log[actualOperation * 2 +1] = heigh[0][0];
                if (heigh[0][1] > heigh[1][1])swap(heigh, 0, 1);
                if (heigh[n - 1][1] < heigh[n - 2][1])swap(heigh, 0, 1);
            }
        }
        System.out.println(heigh[n - 1][1] - heigh[0][1] + " " + actualOperation);
        for (int i = 0; i < actualOperation; i++) {
            System.out.println(log[i * 2] + " " + log[i * 2 + 1]);
        }
    }

    public static void quickSort(int[][] aimArr, int left, int right) {
        //Tool.printArr(aimArr);
        if (left >= right) return;
        int p = partition(aimArr, left, right);
        quickSort(aimArr, left, p - 1);
        quickSort(aimArr, p + 1, right);
    }

    /**
     * 对一段数组进行排序
     * 以最后以为(right)为基准,比它小的往前放
     * 开始i=0,有一个aimArr[j]<=pivot时,swap(i,j)
     * 同时i++,这样将小于基准的数都移到数组前面
     * 最后swap(i,right)
     */
    public static int partition(int[][] aimArr, int left, int right) {
        int pivot = aimArr[right][1];
        int i = left;
        for (int j = left; j < right; j++) {
            if (aimArr[j][1] <= pivot) {
                swap(aimArr, i++, j);
            }
        }
        swap(aimArr, i, right);
        //Tool.printArr(aimArr);
        return i;
    }

    public static void swap(int[][] arr, int i, int j) {
        int t = arr[i][1];
        arr[i][1] = arr[j][1];
        arr[j][1] = t;
        t = arr[i][0];
        arr[i][0] = arr[j][0];
        arr[j][0] = t;
    }

}
