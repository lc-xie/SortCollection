package shuaTi.others;

import java.util.ArrayList;

/**
 * Created by stephen on 18-5-19.
 * 和为S的连续正数序列
 *
 * 原描述：
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列?
 *
 * 思路：
 * 遍历1-sum/2
 * 每次从该数往后加，当出现和等于sum时，表示找到一个Arraylist
 * -----稍显麻烦-----
 */
public class Test1 {
    public static void main(String[] args){
        FindContinuousSequence(32);
    }

    public static ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> outArrayList=new ArrayList<ArrayList<Integer>>();
        if (sum<3)return outArrayList;
        for (int i=1;i<=sum/2;i++){
            int temp=0;
            ArrayList<Integer> list=new ArrayList<>();
            for (int j=i;j<sum;j++){
                temp+=j;
                list.add(j);
                if (temp==sum){
                    outArrayList.add(list);
                    break;
                }else if (temp>sum){
                    break;
                }
            }
        }
        return outArrayList;
    }
}
