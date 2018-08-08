package sort;

/**
 * Created by stephen on 18-4-10.
 * ------------------------归并排序---------------------------
 * 方      式:
 * 稳  定  性: 稳定
 * 时间复杂度: O(nlogn),最差:O(nlogn),最优:O(nlogn)
 * 控件复杂度: O(n)-需要新建一个数组存放数据
 */
public class MergeSort {

    public static void main(String[] args){
        int[] inputArr=new int[]{8,1,2,5,0,3,9,4,6,7};
        mergeSortRecursion(inputArr,0,9);
    }

    /**
     * 递归实现
     * @param aimArr
     * @param left
     * @param right
     */
    public static void mergeSortRecursion(int[] aimArr,int left,int right){
        if (left==right)return;
        int mid=(left+right)/2;
        mergeSortRecursion(aimArr,left,mid);
        mergeSortRecursion(aimArr,mid+1,right);
        merge(aimArr,left,mid,right);
        Tool.printArr(aimArr);
    }

    /**
     * 非递归实现
     */
    public static void mergeSortIteration(){

    }

    public static void merge(int[] aimArr,int left,int mid,int right){
        int[] tempArr=new int[right-left+1];
        int i=left;
        int j=mid+1;
        int index=0;
        while (i<=mid&&j<=right){
            tempArr[index++] = aimArr[i] <= aimArr[j] ? aimArr[i++] : aimArr[j++];
        }
        while (i<=mid){
            tempArr[index++]=aimArr[i++];
        }
        while (j<=right){
            tempArr[index++]=aimArr[j++];
        }
        //sort.Tool.printArr(tempArr);
        System.arraycopy(tempArr,0,aimArr,left,tempArr.length);
        //return aimArr;
    }

}
