package shuaTi.tree;

/**
 * Created by stephen on 18-6-18.
 * 平衡二叉树相关操作
 */
public class AVLHelper {

    //插入

    //LL
    //head为回溯时第一个BF为2/-2的节点
    public void insertLL(AVLTreeNode head) {
        AVLTreeNode p = head.parent;
        AVLTreeNode l = head.left;
        if (p.left == head) {
            p.left = l;
        } else {
            p.right = l;
        }
        head.left=l.right;
        head.parent=l;
        l.right.parent=head;
        l.parent = p;
        l.right = head;
    }

    //RR
    public void insertRR(AVLTreeNode head) {
        AVLTreeNode p = head.parent;
        AVLTreeNode r = head.right;
        //连接r和p
        if (p.left == head) {
            p.left = r;
        } else {
            p.right = r;
        }
        r.parent=p;
        //转移r.left
        r.left.parent=head;
        head.right=r.left;
        //转移head
        r.left=head;
        head.parent=r;
    }

    //LR左右,图形参照幕布
    public void insertLR(AVLTreeNode head) {
        AVLTreeNode p=head.parent;
        AVLTreeNode b=head.left;
        AVLTreeNode c=b.right;//提做新head
        AVLTreeNode cLeft=c.left;
        AVLTreeNode cRight=c.right;
        //转移c
        c.left=b;
        c.right=head;
        c.parent=p;
        if (p.left == head) {
            p.left = c;
        } else {
            p.right = c;
        }
        //完善c右子树
        head.parent=c;
        head.left=cRight;
        cRight.parent=head;
        //完善c左子树
        b.parent=c;
        b.right=cLeft;
        cLeft.parent=b;
    }

    //LR分步算法
    public void insertLR2(AVLTreeNode head) {
        AVLTreeNode l=head.left;
        insertRR(l);
        insertLL(head);
    }

    //RL右左
    public void deleteRL(AVLTreeNode head) {
        AVLTreeNode p=head.parent;
        AVLTreeNode b=head.right;
        AVLTreeNode c=b.left;//提做新head
        AVLTreeNode cLeft=c.left;
        AVLTreeNode cRight=c.right;
        //转移c
        c.left=head;
        c.right=b;
        c.parent=p;
        if (p.left == head) {
            p.left = c;
        } else {
            p.right = c;
        }
        //完善c左子树
        head.parent=c;
        head.right=cLeft;
        cLeft.parent=head;
        //完善c右子树
        b.parent=c;
        b.left=cRight;
        cRight.parent=b;
    }

}