package shuaTi.others;

/**
 * Created by stephen on 18-5-26.
 * 圆圈数数
 * n个人，编号为0,1,2,...,n-1;
 * 以m为基准，从0开始数，数到m-1,该人剔除，求最后剔除人的编号
 * 
 * ？？？约瑟夫环？？？
 */
public class CircleCount {

    public static void main(String[] args){
        System.out.print(LastRemaining_Solution(7,4));
    }

    // TODO: 18-5-26 约瑟夫环解决
    
    //采用链表的形式，将n个数连成一个圈
    //稍显复杂
    public static int LastRemaining_Solution(int n, int m) {
        if(m==0||n==0){
            return -1;
        }
        class Node{
            int number;
            Node next;

            public Node(int n,Node next) {
                this.number=n;
                this.next=next;
            }
        }
        //创建链表
        Node head=new Node(0,null);
        Node left=head;
        for (int i=1;i<n;i++){
            Node node=new Node(i,null);
            left.next=node;
            left=node;
        }
        left.next=head;
        int count=1;
        while (head.next!=head){
            if (count==m-1){
                head.next=head.next.next;
                count=0;
            }else {
                count++;
                head=head.next;
            }
        }
        return head.number;
    }
}
