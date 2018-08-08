package shuaTi.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stephen on 18-6-15.
 * 二叉树的基本算法
 */
public class BaseTreeAlgorithm {
    /**
     * 遍历
     */
    //先序
    public static void preTraverse(TreeNode node){
        System.out.print(node.val+"--");
        if (node.leftChild!=null)preTraverse(node.leftChild);
        if (node.rightChild!=null)preTraverse(node.rightChild);
    }
    //中序
    public static void inTraverse(TreeNode node){
        if (node.leftChild!=null)inTraverse(node.leftChild);
        System.out.print(node.val+"--");
        if (node.rightChild!=null)inTraverse(node.rightChild);
    }

    /*public TreeNode toList(TreeNode node){
        if (node.leftChild!=null)inTraverse(node.leftChild);
        System.out.print(node.val+"--");
    }*/



    //后序
    public static void beTraverse(TreeNode node)    {
        if (node.leftChild!=null)preTraverse(node.leftChild);
        if (node.rightChild!=null)preTraverse(node.rightChild);
        System.out.print(node.val+"--");
    }

    public static void main(String[] args){
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(4);
        TreeNode n5=new TreeNode(5);
        TreeNode n6=new TreeNode(6);
        TreeNode n7=new TreeNode(7);

        n1.leftChild=n2;
        n1.rightChild=n3;
        n2.leftChild=n4;
        n3.leftChild=n5;
        n3.rightChild=n6;
        n5.rightChild=n7;

        preTraverse(n1);
        System.out.println();
        inTraverse(n1);
        System.out.println();
        beTraverse(n1);
    }
}
