package designpattern.FactoryDesignPattern;

/**
 * Created by stephen on 18-4-19.
 * 工厂模式测试
 */
public class Test {
    private static FactoryInterface benchiFactory,bmwFactory;
    public static void main(String[] args) throws Exception{
        System.out.println("------工厂方法模式测试------");

        benchiFactory=new BenChiFactory();
        bmwFactory=new BMWFactory();

        Car benchiCar=benchiFactory.getCar();
        benchiCar.drive();

        Car bmwCar=bmwFactory.getCar();
        bmwCar.drive();
    }

    public static void simpleFactoryTest() throws Exception{
        System.out.println("------简单工厂模式测试------");

        Car bmw=CarFactory.getCar("bmw");
        bmw.drive();

        Car benchi=CarFactory.getCar("benchi");
        benchi.drive();
    }
}
