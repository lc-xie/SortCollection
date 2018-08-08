package shuaTi.qiuzhao.pdd;

import java.util.Scanner;

/**
 * 二叉树前序中序获取后续
 */
public class PDDTest2 {

    static class Node {
        int val;
        Node left, right;

        public Node(int v) {
            val = v;
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] pre = new int[n];
        int[] in = new int[n];
        for (int i = 0; i < n; i++) {
            pre[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            in[i] = sc.nextInt();
        }
        Node root = buildTree(pre, 0, n-1, in, 0, n-1);
        after(root);
    }

    /**
     * 通过前序和中序构建树
     *
     * @return 树根节点
     */
    public static Node buildTree(int[] pre, int s1, int e1, int[] in, int s2, int e2) {
        Node root = new Node(pre[s1]);
        if (s1 == e1 && s2 == e2) {
            //叶节点，直接返回
            return root;
        }
        int lable = s2;
        for (; lable <= e2; lable++) {
            if (in[lable] == root.val) break;
        }
        if (lable == s2) {
            //没有左子树
            root.left = null;
        } else {
            root.left = buildTree(pre, s1 + 1, s1+lable-s2, in, s2, lable - 1);
        }
        if (lable == e2) {
            //没有右子树
            root.right = null;
        } else {
            root.right = buildTree(pre, s1+lable-s2+1, e1, in, lable + 1, e2);
        }
        return root;
    }

    public static void after(Node root) {
        if (root.left != null) {
            after(root.left);
        }
        if (root.right!=null){
            after(root.right);
        }
        System.out.print(root.val+" -> ");
    }
}
