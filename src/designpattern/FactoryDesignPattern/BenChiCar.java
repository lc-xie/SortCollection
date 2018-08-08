package designpattern.FactoryDesignPattern;

/**
 * Created by stephen on 18-4-19.
  * 具体的产品类---奔驰
 */
public class BenChiCar extends Car {
    @Override
    public void drive() {
        System.out.println("驾驶奔驰!");
    }
}
