package tree;

import java.util.ArrayList;

/**
 * Created by stephen on 18-8-9.
 * <p>
 * 最小堆
 */

public class MinHeap<E extends Comparable> {

    private ArrayList<E> list = new ArrayList<>();

    public MinHeap() {
    }

    /**
     * 构建堆
     *
     * @param inputArr
     */
    public MinHeap(E[] inputArr) {
        for (int i = 0; i < inputArr.length; i++) {
            this.add(inputArr[i]);
        }
    }

    /**
     * 构建堆
     *
     */
    public MinHeap(ArrayList<E> inputArr) {
        for (int i = 0; i < inputArr.size(); i++) {
            this.add(inputArr.get(i));
        }
    }

    /**
     * 向堆中添加元素
     *
     * @param e
     */
    public void add(E e) {
        list.add(e);
        int currentIndex = list.size() - 1;
        while (currentIndex > 0) {
            int parentIdex = (currentIndex - 1) / 2;
            int cmp = list.get(currentIndex).compareTo(list.get(parentIdex));
            if (cmp > 0) {
                break;
            }
            E temp = list.get(currentIndex);
            list.set(currentIndex, list.get(parentIdex));
            list.set(parentIdex, temp);
            currentIndex = (currentIndex - 1) / 2;
        }
    }

    /**
     * 获取堆顶元素
     *
     * @return
     */
    public E getTop() {
        if (list.size() == 0) return null;
        return list.get(0);
    }

    /**
     * 将堆顶元素删除(出队列)
     *
     * @return
     */
    public E dequeueTop() {
        E top = getTop();
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        //调整
        heapify();
        return top;
    }

    /**
     * 自顶向下调整堆
     */
    public void heapify() {
        int curIndex = 0;
        int child = curIndex * 2 + 1;
        while (child < list.size()) {    //左节点是否存在，不存在就不需要继续调整
            if (child + 1 < list.size()) {  //防止数组越界
                child = list.get(child).compareTo(list.get(child + 1)) < 0 ? child : ++child;
            }
            int compare = list.get(curIndex).compareTo(list.get(child));
            if (compare < 0) {
                break;
            } else {
                E temp = list.get(curIndex);
                list.set(curIndex, list.get(child));
                list.set(child, temp);
                curIndex = child;
                child = curIndex * 2 + 1;
            }
        }
    }


}
