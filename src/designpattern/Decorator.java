package designpattern;

/**
 * Created by stephen on 18-6-12.
 * 装饰模式
 */
public class Decorator {

    abstract class Person{
        abstract void dress();
    }

    class Boy extends Person{
        @Override
        void dress() {
            System.out.print("穿着男生衣服.");
        }
    }

    abstract class PersonDecorator extends Person{
        public Person mPerson;

        public PersonDecorator(Person person){
            this.mPerson=person;
        }

        @Override
        void dress() {
            mPerson.dress();
        }
    }

    class Demo1 extends PersonDecorator{
        public Demo1(Person person) {
            super(person);
        }

        private void newMethod1(){
            System.out.print("穿短袖");
        }

        private void newMethod2(){
            System.out.print("穿短裤");
        }
        //在这里重写dress方法，加入新的逻辑
        @Override
        void dress() {
            newMethod1();
            super.dress();
            newMethod2();
        }
    }

}
