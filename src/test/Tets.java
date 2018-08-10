package test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.lang.ref.Reference;

/**
 * Created by stephen on 18-5-11.
 */
public class Tets {
    
    public static void main(String[] args){
        int[] arr = new int[]{3,2,7,5,8,1,4};
        quickSort(arr,0,6);
        for (int t:arr){
            System.out.print(t+" ");
        }
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l>=r)return;
        int j=l;
        for (int i=l; i<r; i++){
            if (arr[i]<arr[r]){
                int t = arr[j];
                arr[j++] = arr[i];
                arr[i] = t;
            }
        }
        int tt = arr[j];
        arr[j] = arr[r];
        arr[r] = tt;
        quickSort(arr, l, j-1);
        quickSort(arr, j+1, r);
    }
}
