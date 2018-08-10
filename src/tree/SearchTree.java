package tree;

/**
 * Created by stephen on 18-6-16.
 * 二叉查找树
 */
public class SearchTree {
    //查找---递归
    public TreeNode search(TreeNode head,int key){
        if (head==null||head.val==key)return head;
        return head.val>key?search(head.leftChild,key):search(head.rightChild,key);
    }
    //查找---循环
    public TreeNode search2(TreeNode head,int key){
        while (head!=null&&head.val!=key){
            if (head.val>key){
                head=head.leftChild;
            }else {
                head=head.rightChild;
            }
        }
        return head;
    }
    //最小值
    public TreeNode min(TreeNode head){
        while (head.leftChild!=null){
            head=head.leftChild;
        }
        return head;
    }
    //最大值
    public TreeNode max(TreeNode head){
        while (head.rightChild!=null){
            head=head.rightChild;
        }
        return head;
    }
    //后继---比x大的最近的节点(x右子树中最小节点)
    public TreeNode successor(TreeNode x){
        if (x.rightChild!=null){
            return min(x.rightChild);
        }else { //右子树为空时，向上搜寻前趋节点，即不断找寻父节点，直到比x大
            TreeNode y=x.parent;
            while (y!=null&&x==y.rightChild){
                x=y;
                y=y.parent;
            }
            return y;
        }
    }
    //前趋---比x小的最近的节点(x左子树中最大节点)
    public TreeNode predecessor(TreeNode x){
        if (x.leftChild!=null){
            return max(x.leftChild);
        }else { //左子树为空时，向上搜寻前趋节点，即不断找寻父节点，直到比x小
            TreeNode y=x.parent;
            while (y!=null&&x==y.leftChild){
                x=y;
                y=y.parent;
            }
            return y;
        }
    }

    //插入数据---插入到叶节点后面
    public void insert(TreeNode head,TreeNode z){
        TreeNode p=null;
        TreeNode x=head;
        while (x!=null){
            p=x;
            if (x.val>z.val){
                x=x.leftChild;
            }else {
                x=x.rightChild;
            }
        }
        z.parent=p;
        if (p==null){//树为空
            head=z;
        }else {
            if (p.val<z.val){
                p.rightChild=z;
            }else {
                p.leftChild=z;
            }
        }
    }

    //删除---三种情况
    public void delete(TreeNode z){
        if (z==null)return;
        TreeNode p=null;
        TreeNode x=null;
        if (z.leftChild!=null&&z.rightChild!=null){ //左右节点都不为空
            //删除z的后继，再将后继的值赋给z，相当于把后继节点和z交换
            x=successor(z);
            z.val=x.val;//交换值
            delete(z);//删除后继节点，注意，后继节点的子节点数小于2
        }else {                                     //一个子树为空或两个都为空
            if (z.leftChild!=null){
                x=z.leftChild;
            }else x=z.rightChild;
            p=z.parent;
            x.parent=p;
            if (p!=null){
                if (p.leftChild==z){
                    p.leftChild=x;
                }else {
                    p.rightChild=x;
                }
            }
        }
    }
    //书上的算法，感觉if-else太多，有点眼花缭乱
    public void delete2(TreeNode z){
        TreeNode p=null;
        TreeNode x=null;
        //找到要删除的节点
        if (z.leftChild==null||z.rightChild==null){
            p=z;
        }else {
            p=successor(z);
        }
        //删除p
        if (p.leftChild!=null){
            x=p.leftChild;
        }else {
            x=p.rightChild;
        }
        if (x!=null)x.parent=p.parent;
        if (p.parent==null){//z为根节点
            //x=根节点
        }else if (p==p.parent.rightChild){
            p.parent.rightChild=x;
        }else {
            p.parent.leftChild=x;
        }
        //最后，若是第三种情况，需要交换值
        if (p!=z)z.val=p.val;
    }

}
