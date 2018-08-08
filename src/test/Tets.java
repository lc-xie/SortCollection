package test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.lang.ref.Reference;

/**
 * Created by stephen on 18-5-11.
 */
public class Tets {

    static class Demo{
        int lable;
        Demo next;

        public Demo(int lable){
            this.lable=lable;
        }
    }
    
    public static void main(String[] args){
        Demo demo1=new Demo(2);
        Demo demo2=new Demo(3);
        demo1.next=demo2;
        Map<Integer,Demo> map=new HashMap<>();
        map.put(demo1.lable,demo1);
        map.put(demo2.lable,demo2);
        demo2.next=demo1;
        System.out.print(map.get(demo2.lable).next.lable);
    }
}
