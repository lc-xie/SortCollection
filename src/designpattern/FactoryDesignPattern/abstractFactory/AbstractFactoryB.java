package designpattern.FactoryDesignPattern.abstractFactory;

/**
 * Created by stephen on 18-4-20.
 * 抽象工厂类,用于创建商务车这一产品族
 */
public abstract class AbstractFactoryB {
    abstract BussinessCar getBCar1();
    abstract BussinessCar getBCar2();
}
