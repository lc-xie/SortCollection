package shuaTi;

public class Leetcode {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 将单链表中奇数位置的节点提取到前面，偶数位置节点提取到后面,要求space O(1), time O(n)
     * 如：
     * input:  s(1) -> g(2) -> l(3) -> y(4) -> o(5) -> m(6) -> w(7) -> q(8)
     * output: s(1) -> l(3) -> o(5) -> w(7) -> g(2) -> y(4) -> m(6) -> q(8)
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode evenHead = head.next;
        ListNode even = evenHead;
        ListNode odd = head;
        while (odd.next != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    /**
     * 删除单链表倒数第n个数
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        int i = 0;
        int lable = -1;
        while (true) {
            if (lable == i) {
                temp.next = temp.next.next;
                break;
            }
            if (temp.next != null) {
                temp = temp.next;
                i++;
                continue;
            }
            lable = i - n;
            i = 0;
            temp = pre;
        }
        return pre.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {

        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for(int i=1; i<=n+1; i++)   {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i < 8; i++) {
            ListNode newNode = new ListNode(i);
            temp.next = newNode;
            temp = newNode;
        }
        head = removeNthFromEnd(head, 1);
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }

}
