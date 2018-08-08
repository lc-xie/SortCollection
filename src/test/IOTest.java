package test;

import java.io.*;

/**
 * Created by stephen on 18-5-10.
 * IO 测试
 */
public class IOTest {
    public static String filePath3 ="/home/stephen/CLion/input3.txt";
    public static String filePath1 ="/home/stephen/CLion/input1.txt";
    public static String filePath2 ="/home/stephen/CLion/input2.txt";
    public static String filePath4 ="/home/stephen/CLion/input4.txt";

    public static void main(String[] args) {
        System.out.print(readFile());
    }

    public static String readFile(){
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(filePath1);
            String s1="12121212";
            fileOutputStream.write(s1.getBytes());
            fileOutputStream.close();
            FileOutputStream fileOutputStream1=new FileOutputStream(filePath1);

            String s2="33333";
            fileOutputStream1.write(s2.getBytes());

            FileInputStream fileInputStream=new FileInputStream(filePath1);
            BufferedReader buff = new BufferedReader(new InputStreamReader(
                    fileInputStream, "utf-8"));
            return buff.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void fileReaderTest(){
        FileReader fileReader=null;
        PrintWriter writer=null;
        try {
            fileReader=new FileReader(filePath1);
            writer=new PrintWriter(System.out);//输出到控制台
            //writer=new PrintWriter(filePath4);//输出到文件

            char [] bytes=new char[40];
            int len;
            while ((len=fileReader.read(bytes))!=-1){
                writer.write(bytes,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fileReader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
            writer.close();
        }
    }

    public static void sequenceInputTest(){
        SequenceInputStream sequenceInputStream=null;
        BufferedOutputStream bufferedOutputStream=null;
        FileOutputStream fileOutputStream=null;
        try {
            //使用这种方法可以添加多个输入流,但是出现了乱码
           /* Vector<InputStream> inputStreams=new Vector<>();
            inputStreams.addElement(new FileInputStream("/home/stephen/CLion/input1.txt"));
            inputStreams.addElement(new FileInputStream("/home/stephen/CLion/input2.txt"));
            inputStreams.addElement(new FileInputStream("/home/stephen/CLion/input3.txt"));
            Enumeration<InputStream> enumeration=inputStreams.elements();*/
            //这种方法没有乱码,只能添加两个输入流
            sequenceInputStream=new SequenceInputStream(
                    new FileInputStream("/home/stephen/CLion/input1.txt"),
                    new FileInputStream("/home/stephen/CLion/input2.txt"));
            //fileOutputStream=new FileOutputStream("/home/stephen/CLion/input4.txt");
            bufferedOutputStream=new BufferedOutputStream(new FileOutputStream("/home/stephen/CLion/input4.txt"));
            byte[] bytes=new byte[1024];
            int len=0;
            while ((len=sequenceInputStream.read(bytes))!=-1){
                bufferedOutputStream.write(bytes,0,len);
                bufferedOutputStream.flush();
                //fileOutputStream.write(bytes,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (sequenceInputStream!=null){
                    sequenceInputStream.close();
                }
                if (fileOutputStream!=null){
                    fileOutputStream.close();
                }
                if (bufferedOutputStream!=null){
                    bufferedOutputStream.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void pushBackIOStreamTest(){
        String str = "hello,rollenholt";
        PushbackInputStream push = null; // 声明回退流对象
        ByteArrayInputStream bat = null; // 声明字节数组流对象
        try {
            bat = new ByteArrayInputStream(str.getBytes());
            push = new PushbackInputStream(bat); // 创建回退流对象，将拆解的字节数组流传入
            int temp = 0;
            while ((temp = push.read()) != -1) { // push.read()逐字节读取存放在temp中，如果读取完成返回-1
                if (temp == ',') { // 判断读取的是否是逗号
                    push.unread(temp); //回到temp的位置
                    temp = push.read(); //接着读取字节
                    System.out.print("(回退" + (char) temp + ") "); // 输出回退的字符
                } else {
                    System.out.print((char) temp); // 否则输出字符
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void dataIOStreamTest(){
        IOTestObject[] array=new IOTestObject[]{
           new IOTestObject("test1",89),new IOTestObject("test2",23),new IOTestObject("test3",56)
        };
        try {
            DataOutputStream dataOutputStream=new DataOutputStream(new FileOutputStream(filePath3));
            for (IOTestObject ioTestObject:array){
                dataOutputStream.writeUTF(ioTestObject.name);
                //dataOutputStream.writeInt(ioTestObject.age);
            }
            dataOutputStream.flush();//将数据送至目的地
            dataOutputStream.close();

            //读取数据
            DataInputStream dataInputStream=new DataInputStream(new FileInputStream(filePath3));
            for (int i=array.length-1;i>=0;i--){
                String name=dataInputStream.readUTF();
                //int age=dataInputStream.readInt();
                array[i]=new IOTestObject(name);
            }
            dataInputStream.close();
            for (IOTestObject ioTestObject:array){
                System.out.println(ioTestObject.toString());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void objectIOStreamTest(){
        ObjectInputStream objectInputStream=null;
        ObjectOutputStream objectOutputStream=null;//注意,这里不能用OutputStream,否则后面无法使用writeObject方法
        try{
            objectOutputStream=new ObjectOutputStream(new FileOutputStream("/home/stephen/CLion/input3.txt"));
            objectOutputStream.writeObject(new IOTestObject("o1",21));
            objectOutputStream.writeObject(new IOTestObject("o2",32));
            objectOutputStream.writeObject(new IOTestObject("o3",45));

            objectInputStream=new ObjectInputStream(new FileInputStream("/home/stephen/CLion/input3.txt"));
            for (int i=0;i<3;i++) {
                System.out.println(objectInputStream.readObject());
            }
        }catch (IOException|ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            try {
                objectInputStream.close();
                objectOutputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void fileIOStreamTest(){
        InputStream inputStream=null;
        OutputStream outputStream=null;
        try {
            int count=0;
            inputStream=new FileInputStream(new File("/home/stephen/CLion/input.txt"));
            byte[] bytes=new byte[20];
            int i=0;
            outputStream=new FileOutputStream(new File("/home/stephen/CLion/input2.txt"));

            while ((i=inputStream.read(bytes))!=-1){
                count+=i;
                System.out.println(count);
                outputStream.write(bytes,0,i);
            }
            outputStream.write(42);
            outputStream.write(42);
            outputStream.write(52);
            outputStream.write(62);
            outputStream.write(72);

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
