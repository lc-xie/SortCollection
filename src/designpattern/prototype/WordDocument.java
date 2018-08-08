package designpattern.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stephen on 18-6-16.
 * 文件类，实现Cloneable接口
 */
public class WordDocument implements Cloneable {
    private String text;
    private ArrayList<String> mImages = new ArrayList<String>();

    public WordDocument() {
        System.out.println("----------- WordDocument构造函数 -----------");
    }
    //重写clone()方法
    @Override
    protected WordDocument clone() throws CloneNotSupportedException {
        try {
            WordDocument doc2=(WordDocument)super.clone();
            doc2.text=this.text;
            //doc2.mImages=this.mImages;
            doc2.mImages=(ArrayList<String>)this.mImages.clone();
            return doc2;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public String getText() {
        return text;
    }

    public void setText(String mText) {
        this.text = mText;
    }

    public List<String> getImages() {
        return mImages;
    }

    public void addImage(String img) {
        this.mImages.add(img);
    }

    /**
     * 打印文档内容
     */
    public void showDocument() {
        System.out.println("----------- Word Content Start -----------");
        System.out.println("Text : " + text);
        System.out.println("Images List: ");
        for (String imgName : mImages) {
            System.out.println("image name : " + imgName);
        }
        System.out.println("----------- Word Content End -----------");
    }
}
