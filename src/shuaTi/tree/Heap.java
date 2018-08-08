package shuaTi.tree;

import java.util.ArrayList;

/**
 * Created by stephen on 18-8-8.
 */

public class Heap<E extends Comparable> {

    private ArrayList<E> list = new ArrayList<E>(); //用数组存储

    public Heap() {
        super();
    }

    /**
     * 获取堆顶的元素（出队列）
     */
    public E getTop(){
        return list.get(0);
    }

    /**
     * 添加一个元素
     * 由下往上调整
     */
    public void add(E e){
        list.add(e);    //加入数组尾部
        int curIndex = list.size()-1;
        //调整位置
        while (curIndex>0 && list.get(curIndex).compareTo(list.get((curIndex - 1)/2))>0){
            E temp=list.get(curIndex);
            list.set(curIndex, list.get((curIndex - 1)/2));
            list.set((curIndex - 1)/2, temp);
            curIndex = (curIndex - 1)/2;
        }
    }

    /**
     * 删除堆顶元素---出队列（堆是一个队列，只能获取队列前面的数据，不能获取中间数据，更不能从中间删除）
     * 由上往下调整
     */
    public E delete(){
        if (list.size()==0)return null;
        //用最后一个元素填充并删除最后一个元素
        E last = list.get(list.size()-1);
        list.set(0,last);
        list.remove(list.size()-1);
        //调整
        heapify();
        return getTop();
    }

    /**
     * 使删除堆顶元素后再次成为堆
     */
    private void heapify(){
        int curIndex = 0;
        int child = curIndex*2 + 1;
        while (child < list.size()){    //左节点是否存在，不存在就不需要继续调整
            if (child+1<list.size()) {  //防止数组越界
                child = list.get(child).compareTo(list.get(child + 1)) > 0 ? child : ++child;
            }
            int compare = list.get(curIndex).compareTo(list.get(child));
            if (compare > 0){
                break;
            }else {
                E temp = list.get(curIndex);
                list.set(curIndex,list.get(child));
                list.set(child,temp);
                curIndex = child;
                child = curIndex*2 + 1;
            }
        }
    }

    /**
     * 打印所有元素
     */
    public void printAll(){
        for (int i=0;i<list.size();i++){
            System.out.print(list.get(i)+"  ");
            if (i==0 || i==2 || i==6 || i==14 || i==30 || i==62){
                System.out.println();
            }
        }
        System.out.println();
    }

    public void printAll2(){
        for (int i=0;i<list.size();i++){
            System.out.print(list.get(i)+"  ");
        }
        System.out.println();
    }
}
