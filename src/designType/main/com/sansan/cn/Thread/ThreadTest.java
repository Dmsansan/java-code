package designType.main.com.sansan.cn.Thread;

import designType.main.com.sansan.cn.Thread.process.*;

public class ThreadTest {
    public static void main(String[] args) {
        ThreadTest1();
        ThreadTest2();
        ThreadTest3();
        ThreadTest4();
        ThreadTest5();
    }

    private static void ThreadTest1() {
        Thread t = Thread.currentThread();
        System.out.println(t.getId());
        Thread t1 = new Thread(new Process1());
        t1.setName("t1");
        t1.start();
        Thread t2 = new Thread(new Process1());
        t2.setName("t2");
        t2.start();

    }

    private static void ThreadTest2() {
        Thread t1 = new Process2();
        Thread t2 = new Process2();
        t1.setName("t1");
        t2.setName("t2");

        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        t1.setPriority(1);
        t2.setPriority(10);
        t1.start();
        t2.start();
    }

    private static void ThreadTest3() {
        Thread t = new Thread(new Process3());
        t.start();
        for (int i = 0; i < 11; i++) {
            System.out.println(Thread.currentThread().getName()+"====================>"+i);
            try{
                t.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private static void ThreadTest4() {
        try {
            Thread t = new Thread(new Process4());
            t.start();
            Thread.sleep(5000);
            t.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void ThreadTest5() {
        Process5 p = new Process5();
        Thread t = new Thread(p);
        t.start();
        // 5s之后终止
        try {
            Thread.sleep(5000);
            p.isRun = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
