package com.fuqiang.volatiles;

/**
 * @author fuqiang
 * @version Volatile01, v0.1 2018/11/2 19:11
 */
public class Volatile01 {

    volatile boolean stop = false;

    public void shutDown() {
        stop = true;
    }

    public void doWork() {
        while (!stop) {

        }
        System.out.println("你能读到我吗......");
    }

    public static void main(String[] args) throws InterruptedException {
        Volatile01 volatile01 = new Volatile01();
        new Thread(()->{
            volatile01.doWork();
        }).start();
        Thread.sleep(1000);
        new Thread(()->{
            volatile01.shutDown();
        }).start();

    }
}
