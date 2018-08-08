package designpattern.FactoryDesignPattern.abstractFactory;

/**
 * Created by stephen on 18-4-20.
 * 抽象工厂模式测试类
 */
public class Test {
    public static void main(String[] args){
        SportCarFactory sportCarFactory=new SportCarFactory();
        SportCar sCar1=sportCarFactory.getSCar1();
        sCar1.drive();
        SportCar sCar2=sportCarFactory.getSCar2();
        sCar2.drive();

        BuissinessCarFactory buissinessCarFactory=new BuissinessCarFactory();
        BussinessCar bCar1=buissinessCarFactory.getBCar1();
        bCar1.drive();
        BussinessCar bCar2=buissinessCarFactory.getBCar2();
        bCar2.drive();
    }
}
