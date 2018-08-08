package designpattern.strategy;

/**
 * Created by stephen on 18-6-18.
 */
public class Test {
    public static void main(String[] args){
        //具体的策略选择还是由客户端完成
        //要计算bus的价格
        TranficCalculator calculator=new TranficCalculator();
        calculator.setStrategyI(new BusStrategy());
        calculator.calculatePrice();
    }
}
