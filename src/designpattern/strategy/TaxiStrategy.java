package designpattern.strategy;

/**
 * Created by stephen on 18-6-18.
 * 策略三：TAXI
 */
public class TaxiStrategy implements StrategyI {
    @Override
    public int calculate() {
        return 3;
    }
}
