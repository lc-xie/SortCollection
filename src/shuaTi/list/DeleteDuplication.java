package shuaTi.list;

import java.util.Map;

/**
 * Created by stephen on 18-6-4.
 * 删除排序链表中重复的节点
 * 请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {
    public static void main(String[] args){
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(1);
        ListNode n3=new ListNode(2);
        ListNode n4=new ListNode(3);
        ListNode n5=new ListNode(3);
        ListNode n6=new ListNode(4);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        System.out.println(n1.val);
        System.out.println(n2.val);
        System.out.println(n3.val);
        System.out.println(n4.val);
        System.out.println(n5.val);
        System.out.println(n6.val);
        ListNode n=deleteDuplication(n1);
        while (n!=null){
            System.out.println(n.val);
            n=n.next;
        }
    }

    public static ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead==null||pHead.next==null)return pHead; //节点为空或只有一个节点时直接返回
        if (pHead.next.val!=pHead.val){                 //第一个节点元素不重复,即为头节点
            ListNode head=pHead;
            head.next=deleteDuplication(head.next);     //寻找头节点的下一个节点
            return head;    //最后返回的是头节点
        }else {             //节点重复时
            while (pHead.next!=null&&pHead.val==pHead.next.val){
                pHead=pHead.next;
            }
            return deleteDuplication(pHead.next);
        }
    }

}
