package designpattern.FactoryDesignPattern.abstractFactory;

/**
 * Created by stephen on 18-4-20.
 * 具体产品类
 */
public class BCar1 implements BussinessCar{
    @Override
    public void drive() {
        System.out.println("商务车 : car1");
    }
}
