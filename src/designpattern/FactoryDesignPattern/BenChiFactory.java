package designpattern.FactoryDesignPattern;

/**
 * Created by stephen on 18-4-19.
 * 具体工厂类---奔驰车生产类
 */
public class BenChiFactory implements FactoryInterface {
    @Override
    public Car getCar() {
        return new BenChiCar();
    }
}
