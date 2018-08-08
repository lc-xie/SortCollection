package designpattern.FactoryDesignPattern.abstractFactory;

/**
 * Created by stephen on 18-4-20.
 * 具体产品类
 */
public class SCar2 implements SportCar {
    @Override
    public void drive() {
        System.out.println("跑车 : car2");
    }
}
