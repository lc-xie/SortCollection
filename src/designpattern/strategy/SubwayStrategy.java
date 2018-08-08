package designpattern.strategy;

/**
 * Created by stephen on 18-6-18.
 * 策略二：SUBWAY
 */
public class SubwayStrategy implements StrategyI {
    @Override
    public int calculate() {
        return 2;
    }
}
