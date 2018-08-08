package shuaTi.list;

public class SingleLinkedList {

    /**
     * 单链表节点
     */
    class Node {
        int val;
        Node next;

        public Node(int v) {
            this.val = v;
        }
    }

    /**
     * 获取单链表环的入口
     *
     * @param head
     * @return
     */
    public Node getEntrance(Node head) {
        //两个指针以不同的速度遍历知道相遇
        Node v1 = head;//一倍速
        Node v2 = head;//二倍速
        while (true) {
            v1 = v1.next;
            v2 = v2.next.next;
            //相遇之后，v2回到head，两者再以一样的速度遍历，相遇点即为环入口
            if (v1 == v2) {
                v2 = head;
                while (v1 != v2) {
                    v1 = v1.next;
                    v2 = v2.next;
                }
                return v1;
            }
        }
    }

    /**
     * 复杂链表节点
     */
    class RandomNode {
        int val;
        RandomNode next;
        RandomNode random;

        public RandomNode(int v) {
            this.val = v;
        }
    }

    /**
     * 复制复杂链表
     * 复杂链表：在单链表的形式下，某些节点还有一个randomNode指向任一节点
     *
     * @param head
     * @return
     */
    public RandomNode copyRandomList(RandomNode head) {
        if (head.next == null) {
            RandomNode node = new RandomNode(head.val);
            if (head.random != null) node.random = node;
            return node;
        }
        //插入新节点
        RandomNode temp = head;
        while (temp != null) {
            RandomNode node = new RandomNode(temp.val);
            node.next = temp.next;
            temp.next = node;
            temp = node.next;
        }
        //复制random节点
        temp = head;
        while (temp != null) {
            if (temp.random!=null){
                temp.next.random=temp.random.next;
            }
            temp=temp.next.next;
        }
        //删除原节点
        temp=head.next;
        while (temp.next!=null){
            temp.next=temp.next.next;
        }
        return head.next;
    }
}
