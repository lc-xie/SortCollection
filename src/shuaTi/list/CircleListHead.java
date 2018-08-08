package shuaTi.list;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by stephen on 18-6-2.
 * 一个单向链表中包含环，请找出该链表的环的入口结点。
 */
public class CircleListHead {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        Map<Integer,Integer> map=new HashMap<>();
        int i=1;
        while (!map.containsValue(pHead.hashCode())){
            map.put(i++,pHead.hashCode());
            pHead=pHead.next;
        }
        return pHead;
    }

    public ListNode EntryNodeOfLoop2(ListNode pHead){
        if (pHead==null||pHead.next==null)return null;
        ListNode p1=pHead;
        ListNode p2=pHead;
        while (p2!=null&&p2.next!=null){
            p1=p1.next;         //一倍速度
            p2=p2.next.next;    //两倍速度
            if (p1==p2){        //相遇时刚好在中点处(p1走了半程，p2走了全程)
                p2=pHead;       //p2回到起点，而p1处于中点不变
                while (p1!=p2){ //两者再次以同一速度前进，相遇处即为环入口
                    p1=p1.next;
                    p2=p2.next;
                }
                if (p1==p2)return p1;
            }
        }
        return null;
    }


    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
