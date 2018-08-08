package shuaTi.list;

/**
 * Created by stephen on 18-6-10.
 * 合并两个有序链表
 */
public class MergeList {

    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1==null)return list2;
        if (list2==null)return list1;
        ListNode temp=new ListNode(-1);
        ListNode head=temp;
        while (list1!=null&&list2!=null){
            if (list1.val<list2.val){
                head.next=list1;
                list1=list1.next;
            }else {
                head.next=list2;
                list2=list2.next;
            }
            head=head.next;
            if (list1==null){
                head.next=list2;
                break;
            }else if (list2==null){
                head.next=list1;
                break;
            }
        }
        return temp.next;
    }

    //递归版本
    public ListNode merge(ListNode list1,ListNode list2) {
        if (list1==null)return list2;
        if (list2==null)return list1;
        ListNode head;
        if (list1.val<list2.val){
            head=list1;
            head.next=merge(list1.next,list2);
        }else {
            head=list2;
            head.next=merge(list1,list2.next);
        }
        return head;
    }
}
