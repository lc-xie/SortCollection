package shuaTi.list;

/**
 * Created by stephen on 18-6-10.
 * 反转链表
 */
public class ReverseList {

    public ListNode reverseList(ListNode head){
        if (head==null||head.next==null)return head;
        ListNode left=null;
        ListNode right=null;
        while (head.next!=null){
            right=head.next;
            head.next=left;
            left=head;
            head=right;
        }
        head.next=left;
        return head;
    }

}
