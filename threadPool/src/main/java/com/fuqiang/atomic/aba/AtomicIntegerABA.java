package com.fuqiang.atomic.aba;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fuqiang
 * @version AtomicIntegerABA, v0.1 2018/11/5 18:24
 */
public class AtomicIntegerABA {

    private static AtomicInteger atomicInt = new AtomicInteger(100);

    public static void main(String[] args) throws InterruptedException {
        Thread intT1 = new Thread(new Runnable() {
            @Override
            public void run() {
                atomicInt.compareAndSet(100, 101);
                atomicInt.compareAndSet(101, 100);
            }
        });

        Thread intT2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                }
                boolean c3 = atomicInt.compareAndSet(100, 101);
                System.out.println(c3); // true
                System.out.println(atomicInt.get());
            }
        });
        intT1.start();
        intT2.start();
        intT1.join();
        intT2.join();
    }
}
