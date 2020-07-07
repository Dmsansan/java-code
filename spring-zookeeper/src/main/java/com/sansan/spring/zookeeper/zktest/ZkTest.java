package com.sansan.spring.zookeeper.zktest;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author siss
 * @date 2020/7/7  10:02
 * @deprecated 使用zookeeper实现多线程中分布式锁，使用的是
 *             zookeeper的节点创建的唯一性原则。创建顺序临时节点
 */
public class ZkTest implements Runnable {

    /**
     * 库存
      */
    private static int inventory = 1;
    /**
     * 线程数
      */
    private static int NUM = 10;
    private static CountDownLatch cdl = new CountDownLatch(NUM);

    private static Lock lock = new ReentrantLock();

    private static final String IP_PORT = "124.70.154.139:2181";
    private static final String Z_NODE = "/LOCK";

    private static ZkClient zkClient = new ZkClient(IP_PORT);

    public static void main(String[] args) {
        for (int i = 0; i < NUM; i++) {
            new Thread(new ZkTest()).start();
            cdl.countDown();
        }
//        try {
//            zkClient.createPersistent(Z_NODE);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void run() {
        try {
            zkClient.createPersistent(Z_NODE);
            cdl.await();
            if (inventory > 0) {
                Thread.sleep(5);
                inventory--;
            }
            System.out.println(inventory);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
    }

    public void lock(){
        waitForLock();
        lock();
    }

    public void waitForLock(){
        System.out.println("加锁失败");
        IZkDataListener iZkDataListener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                System.out.println("唤醒");
                cdl.countDown();
            }
        };

        // 监听
        zkClient.subscribeDataChanges(Z_NODE, iZkDataListener);
        if (zkClient.exists(Z_NODE)) {
            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 释放监听
        zkClient.unsubscribeDataChanges(Z_NODE, iZkDataListener);
    }
}
