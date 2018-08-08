package test;

import java.io.Serializable;

/**
 * Created by stephen on 18-5-10.
 * IO读写测试对象
 */
public class IOTestObject implements Serializable {
    String name;
    int age;

    public IOTestObject(String name,int age) {
        this.name=name;
        this.age=age;
    }
    public IOTestObject(String name) {
        this.name=name;
    }

    @Override
    public String toString() {
        return "name:"+this.name+"  age:"+this.age;
    }
}
