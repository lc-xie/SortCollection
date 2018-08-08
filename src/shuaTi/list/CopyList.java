package shuaTi.list;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by stephen on 18-6-12.
 * 复杂链表的复制
 * 每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点
 * 这里默认取出random链接后，原链表为一个单链表！！！
 */
public class CopyList {

    public static RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead==null)return null;
        RandomListNode head=pHead;
        //复制
        while (head!=null){
            RandomListNode temp=new RandomListNode(head.label);
            temp.next=head.next;
            head.next=temp;
            head=temp.next;
            temp=null;
        }
        //设置复制节点的random
        head=pHead;
        while (head!=null){
            if (head.random!=null) {
                head.next.random = head.random.next;
            }else {
                head.next.random=null;
            }
            head=head.next.next;
        }
        //删除原有节点
        head=pHead.next;
        RandomListNode cur=pHead;
        RandomListNode copy=cur.next;
        while (cur!=null){
            cur.next=cur.next.next;
            cur=cur.next;
            /**
             * 这里不能直接cur=cur.next.next
             * 估计是要把与复制链表无关的链接断开
             */
            if (copy.next!=null){
                copy.next=copy.next.next;
                copy=copy.next;
            }
        }
        return head;
    }

}
