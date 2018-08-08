package shuaTi.list;

/**
 * Created by stephen on 18-6-9.
 * 返回链表中-倒数-第k个节点
 */
public class ReturnK {

    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null)return null;
        int count=1;
        ListNode temp=head;
        while (head.next!=null){
            count++;
            head=head.next;
        }

        if (k>count)return null;
        for (int i=0;i<count-k;i++){
            temp=temp.next;
        }
        return temp;
    }

}
