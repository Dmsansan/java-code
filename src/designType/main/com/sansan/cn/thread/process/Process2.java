package designType.main.com.sansan.cn.thread.process;

public class Process2 extends Thread {

    @Override
    public void run(){
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName()+"----------->"+i);
        }
    }
}
