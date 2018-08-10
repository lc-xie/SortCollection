package test;

/**
 * Created by stephen on 18-4-21.
 */
public class ThreadTest extends Thread{
    static int label=0;
    private String name;
    private ThreadTest joinThread;
    public ThreadTest(String name) {
        this.name=name;
    }
    public ThreadTest(String name,ThreadTest joinThread) {
        this.name=name;
        this.joinThread=joinThread;
    }


    @Override
    public void run() {
        if (joinThread!=null){
            try {
                joinThread.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        int t = label++;
        System.out.println("-----线程 "+name+" 执行中-----"+ "label: "+t);
        for (int i=0;i<5;i++){
            try {
                System.out.println("run:"+name+" label: "+t);
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] a){
        ThreadTest test = new ThreadTest("test111111");
        test.run();
        test.start();
        test.run();
        new ThreadTest("test3333").start();
    }
}
