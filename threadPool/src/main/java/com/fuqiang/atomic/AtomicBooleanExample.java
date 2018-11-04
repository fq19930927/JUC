package com.fuqiang.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author fuqiang
 * @version AtomicBooleanExample, v0.1 2018/11/4 23:09
 */
public class AtomicBooleanExample {

    AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    public void shutDown() {
        /**
         * 当内存值V和预期值E相等时,  将内存值替换为新值B
         */
        atomicBoolean.compareAndSet(false, true);
    }

    public void doWork() {
        while (!atomicBoolean.get()) {

        }
        System.out.println("你能读到我吗...");
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicBooleanExample example = new AtomicBooleanExample();
        new Thread(()-> example.doWork()).start();
        Thread.sleep(1000);

        new Thread(()-> example.shutDown()).start();
    }

}
