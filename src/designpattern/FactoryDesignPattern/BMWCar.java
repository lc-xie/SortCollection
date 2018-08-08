package designpattern.FactoryDesignPattern;

/**
 * Created by stephen on 18-4-19.
 * 具体的产品类---宝马
 */
public class BMWCar extends Car{
    @Override
    public void drive() {
        System.out.println("驾驶宝马车!");
    }
}
