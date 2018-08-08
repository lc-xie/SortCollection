package shuaTi.tree;

/**
 * Created by stephen on 18-6-20.
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class TreeToList {


   /* public TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode head=pRootOfTree;
        while (head.leftChild!=null)head=head.leftChild;

        pRootOfTree.leftChild=inTraverse(pRootOfTree.leftChild,pRootOfTree);

        pRootOfTree.rightChild=riTraverse(pRootOfTree);
        return head;
    }*/

    //返回左子树的最大值节点
    /*public TreeNode inTraverse(TreeNode node,TreeNode p){
        TreeNode temp=node;
        while (temp.rightChild!=null){
            temp=temp.rightChild;
        }
        temp.rightChild=p;
    }*/

  /*  //返回右子树的最小值节点
    public TreeNode riTraverse(TreeNode node){

    }
*/
}
