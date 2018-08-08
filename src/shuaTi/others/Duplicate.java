package shuaTi.others;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by stephen on 18-5-27.
 * 找出数组中重复的元素
 */
public class Duplicate {

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        Map tempMap=new HashMap<Integer,Integer>();
        int i=0;
        for (int num:numbers){
            if (tempMap.containsValue(num)){
                duplication[0]=num;
                return true;
            }else {
                tempMap.put(i,num);
                i++;
            }
        }
        return false;
    }

    public int duplicate2(int numbers[],int length) {
        for (int i=0;i<length;i++){
            int index=numbers[i];
            if (index>=length){
                index-=length;
            }
            if (numbers[index]>=length){
                return index;
            }
            numbers[index]+=length;
        }
        return -1;
    }
}
