package com.anbow.java2.test2015.wzy05.first;

import java.util.Scanner;

public class Wangyi2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        arr[0] = sc.nextInt();
        for (int i=1; i < n; i++) {
            arr[i] = sc.nextInt() + arr[i - 1];
        }
        int m = sc.nextInt();
        int[] find = new int[m];
        int[] out = new int[m];
        for (int i=0; i < m; i++) {
            find[i] = sc.nextInt();
            if (i>0 && find[i] == find[i-1]){
                out[i] = out[i-1];
            }
            if (i>0 && find[i] > find[i-1]){
                for (int j = out[i-1]-1; j < n; j++) {
                    if (find[i] <= arr[j]) {
                        out[i] = j+1;
                        break;
                    }
                }
            }
            if (i>0 && find[i] < find[i-1]){
                for (int j = out[i-1]-1; j > 0; j--) {
                    if (find[i] <= arr[j]) {
                        out[i] = j+1;
                        break;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                if (find[i] <= arr[j]) {
                    out[i] = j+1;
                    break;
                }
            }
        }
        for (int i=0;i<m;i++){
            System.out.println(out[i]);
        }
    }

}
