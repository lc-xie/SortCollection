package designpattern.prototype;

/**
 * Created by stephen on 18-6-16.
 * 原型模式
 */
public class Client {

    public static void main(String[] args){

        WordDocument doc1=new WordDocument();
        doc1.setText("文档1");
        doc1.addImage("img1");
        doc1.addImage("img2");
        doc1.addImage("img3");
        doc1.showDocument();
        WordDocument doc2=null;
        try {
            doc2=doc1.clone();
            doc2.showDocument();
        } catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        //修改文档2
        doc2.setText("文档2");//修改String类型不会对原型造成影响
        doc2.addImage("add img");//修改List会对原型造成影响

        doc1.showDocument();
        doc2.showDocument();

        doc1.setText("文档3");//修改String类型不会对复制的对象造成影响
        doc1.addImage("add img2");//修改List会对复制的对象造成影响
        doc1.showDocument();
        doc2.showDocument();

    }
}
