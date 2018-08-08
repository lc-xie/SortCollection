package shuaTi.tree;

/**
 * Created by stephen on 18-6-18.
 * 二叉平衡树
 */
public class AVLTreeNode {
    public int value;
    public AVLTreeNode parent;
    public AVLTreeNode left;
    public AVLTreeNode right;
    public int BF;//平衡因子（-1,0,1）

    public AVLTreeNode(int v) {
        this.value=v;
    }
}
