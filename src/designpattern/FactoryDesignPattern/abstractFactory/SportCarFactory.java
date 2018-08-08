package designpattern.FactoryDesignPattern.abstractFactory;

/**
 * Created by stephen on 18-4-20.
 * 具体工厂类,生产跑车
 */
public class SportCarFactory extends AbstractFactoryS{
    @Override
    SportCar getSCar1() {
        return new SCar1();
    }//生产SCar1

    @Override
    SportCar getSCar2() {
        return new SCar2();
    }//生产SCar1
}
