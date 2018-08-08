package designpattern.strategy;

/**
 * Created by stephen on 18-6-18.
 * 全局策略访问的接口
 */
public class TranficCalculator {

    StrategyI strategyI;

    public void setStrategyI(StrategyI strategyI){
        this.strategyI=strategyI;
    }

    public int calculatePrice(){
        return strategyI.calculate();
    }

}
