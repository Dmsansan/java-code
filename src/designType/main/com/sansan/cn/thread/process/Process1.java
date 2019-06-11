package designType.main.com.sansan.cn.thread.process;

public class Process1 implements Runnable {
    @Override
    public void run() {
        Thread t  = Thread.currentThread();
        System.out.println(t.getId());
        System.out.println(t.getName());
    }
}
