package designType.main.com.sansan.cn.thread.process;

public class Process4 implements Runnable {
    @Override
    public void run() {
        try{
            Thread.sleep(100000000);
            System.out.println("能否执行到这里！！！");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        for (int i = 0; i < 11; i++) {
            System.out.println(Thread.currentThread().getName()+"=============>"+i);
        }
    }
}
