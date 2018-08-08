package test;

/**
 * Created by stephen on 18-4-21.
 */
public class ThreadTest extends Thread{
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
        System.out.println("-----线程 "+name+" 执行中-----");
        for (int i=0;i<5;i++){
            try {
                System.out.println("run:"+name);
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
