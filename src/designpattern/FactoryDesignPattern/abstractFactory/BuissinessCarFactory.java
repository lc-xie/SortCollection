package designpattern.FactoryDesignPattern.abstractFactory;

/**
 * Created by stephen on 18-4-20.
 * 具体工厂类,用于生产商务车
 */
public class BuissinessCarFactory extends AbstractFactoryB {
    @Override
    BussinessCar getBCar1() {
        return new BCar1(); //生产BCar1
    }

    @Override
    BussinessCar getBCar2() {
        return new BCar2();//生产BCar2
    }
}
