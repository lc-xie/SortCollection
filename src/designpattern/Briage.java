package designpattern;

/**
 * Created by stephen on 18-6-8.
 * 桥接模式
 */
public class Briage {
    /**
     * 抽象类
     */
    public abstract class Shape{
        Color color;
        abstract void draw();

        public void setColor(Color color) {
            this.color=color;
        }
    }

    //具体的产品类
    public class Triangle extends Shape{

        @Override
        void draw() {
            System.out.print("三角形："+color);
        }
    }

    public class Square extends Shape{

        @Override
        void draw() {
            System.out.print("正方形："+color);
        }
    }

    /**
     * 接口
     */
    public interface Color{
        public void paint(String shape);
    }
    //接口的实现
    public class White implements Color{
        @Override
        public void paint(String shape) {
            System.out.print("白色的："+shape);
        }
    }

    public class Black implements Color{
        @Override
        public void paint(String shape) {
            System.out.print("黑色的："+shape);
        }
    }

    //测试
    public void main(String[] args){
        Square square=new Square();
        Color white=new White();
        square.setColor(white);//这里将形状和颜色分开了，可以自由使用组合
        square.draw();
    }

}
