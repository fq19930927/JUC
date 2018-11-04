package com.fuqiang.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fuqiang
 * @version Atomic01, v0.1 2018/11/4 23:06
 */
public class Atomic01 implements Runnable {

    static AtomicInteger i = new AtomicInteger();

    @Override
    public void run() {
        add();
    }

    private void add() {
        for (int j = 0; j<10000; j++) {
            i.incrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Atomic01 atomic01 = new Atomic01();
        Thread thread = new Thread(atomic01);
        Thread thread2 = new Thread(atomic01);
        thread.start();
        thread2.start();
        thread.join();thread2.join();
        System.out.println(i.get());
    }

}
