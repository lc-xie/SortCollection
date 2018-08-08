package designpattern.FactoryDesignPattern;

/**
 * Created by stephen on 18-4-19.
 * 具体工厂类---宝马车生产类
 */
public class BMWFactory implements FactoryInterface {
    @Override
    public Car getCar() {
        return new BMWCar();
    }
}
