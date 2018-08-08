package shuaTi.qiuzhao.pdd;

import java.util.Scanner;

/**
 * 一个二位int数组，找出一条最长的路径，
 * 路径要求：每一个位置可以向上下左右四个方向走，切是走“下坡路”，即当前数组的值比你要走的那个值大
 * 这里用动态规划
 */
public class PDDTest1 {
    public static void main(String[] args){
        int row,col;
        Scanner sc=new Scanner(System.in);
        row=sc.nextInt();
        col=sc.nextInt();
        int[][] input=new int[row][col];
        int[][] output=new int[row][col];
        int[][] lable=new int[row][col];
        int maxI=0,maxJ=0;
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                input[i][j]=sc.nextInt();
            }
        }
        int max=1;
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                cal(i,j,input,output, lable,row,col);
                if (max<output[i][j]){
                    max=output[i][j];
                    maxI=i;
                    maxJ=j;
                }
            }
        }
        System.out.println("最大值："+max);
        System.out.print("路径：");
        while (output[maxI][maxJ]!=1){
            System.out.print(input[maxI][maxJ]+" -> ");
            switch (lable[maxI][maxJ]){
                case 1:
                    maxI--;
                    break;
                case 2:
                    maxI++;
                    break;
                case 3:
                    maxJ--;
                    break;
                case 4:
                    maxJ++;
                    break;
            }
        }
        System.out.print(input[maxI][maxJ]);
    }

    public static int cal(int i,int j,int[][] input,int[][] output,int[][] lable, int row,int col){
        if (output[i][j]!=0)return output[i][j];
        int up=1,down=1,left=1,right=1;
        if (i>0&&input[i][j]>input[i-1][j]){
            up+=cal(i-1,j,input,output,lable,row,col);
        }
        if (i<row-1&&input[i][j]>input[i+1][j]){
            down+=cal(i+1,j,input,output,lable,row,col);
        }
        if (j>0&&input[i][j]>input[i][j-1]){
            left+=cal(i,j-1,input,output,lable,row,col);
        }
        if (j<col-1&&input[i][j]>input[i][j+1]){
            right+=cal(i,j+1,input,output,lable,row,col);
        }
        int out=Math.max(Math.max(up,down),Math.max(left,right));
        output[i][j]=out;
        if (out==up){
            lable[i][j]=1;
        }else if (out==down){
            lable[i][j]=2;
        } else if (out==left){
            lable[i][j]=3;
        }else if (out==right){
            lable[i][j]=4;
        }
        return out;
    }
}
