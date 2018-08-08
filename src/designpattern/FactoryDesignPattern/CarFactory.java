package designpattern.FactoryDesignPattern;

/**
 * Created by stephen on 18-4-19.
 * 简单工厂模式
 * 工厂类,生产具体的产品实例
 */
public class CarFactory {
    public static Car getCar(String carName) throws Exception{
        switch (carName){
            case "bmw":
                return new BMWCar();
            case "benchi":
                return new BenChiCar();
            default:
                throw new Exception();
        }
    }
}
