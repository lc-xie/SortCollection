package shuaTi.others;

import java.util.Arrays;

/**
 * Created by stephen on 18-5-25.
 * 判断五张牌是不是顺子（0 可以变成任意数字，牌面值在1-13）
 */
public class ShunZi {

    public static void main(String[] args){
        System.out.print(isContinuous(new int[]{2,7,0,3,0}));
    }

    public static boolean isContinuous(int [] numbers) {
        if(numbers==null||numbers.length<5)return false;
        Arrays.sort(numbers);
        int len=numbers.length;
        int zeroCount=0;
        for (int i=0;i<len-1;i++){
            if (numbers[i]==0){
                zeroCount++;
                continue;
            }
            if (numbers[i]==numbers[i+1])return false;//有两张一样的牌，无法组成顺子
            zeroCount-=numbers[i+1]-numbers[i]-1;
            if (zeroCount<0)return false;
        }
        return true;
    }

    /**
     * 方法二：先计算0的数量，再计算所有牌之间的间隔总数，最后和0的数量比较
     * @param numbers
     * @return
     */
    public static boolean method2(int [] numbers){
        if(numbers==null||numbers.length<5)return false;
        Arrays.sort(numbers);
        int len=numbers.length;
        int zeroCount=0;
        int gapCount=0;
        for (int i=0;i<len-1;i++){
            if (numbers[i]==0){
                zeroCount++;
                continue;
            }
            int temp=numbers[i+1]-numbers[i];
            if (temp==0)return false;
            gapCount+=temp-1;
        }
        if (gapCount<=zeroCount)return true;
        return false;
    }
}
