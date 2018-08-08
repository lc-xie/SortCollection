package shuaTi.tree;

/**
 * Created by stephen on 18-6-15.
 * 二叉树 树节点
 */
public class TreeNode {
    public int val;

    TreeNode parent;
    TreeNode leftChild;
    TreeNode rightChild;

    public TreeNode(int v) {
        this.val=v;
    }
}
