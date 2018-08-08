package designpattern;

/**
 * Created by stephen on 18-6-4.
 * 适配器模式
 */
public class AdapterPattern {

    //目标接口
    interface FiveVolt{
        int get5Volt();
    }
    //需要被转换的对象
    public class Volt220{
        public int get220Volt(){
            return 220;
        }
    }

    //类适配器模式,实现了需要的接口,这样Volt220类可以调用FiveVolt的方法
    public class VoltAdapter extends Volt220 implements FiveVolt{
        @Override
        public int get5Volt() {
            return 5;
        }
    }

    //对象适配器模式,在内部创建一个对象
    public class VoltAdapter2 implements FiveVolt{
        Volt220 volt220;

        public VoltAdapter2(Volt220 volt220) {
            this.volt220=volt220;
        }

        public int get220Volt(){
            return volt220.get220Volt();
        }

        @Override
        public int get5Volt() {
            return 5;
        }
    }

}
