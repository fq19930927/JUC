package com.fuqiang.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fuqiang
 * @version ReentrantLock01, v0.1 2018/11/2 22:41
 */
public class ReentrantLock01 {
    private static final ReentrantLock REENTRANT_LOCK = new ReentrantLock();

    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock01 reentrantLock01 = new ReentrantLock01();
        new Thread(()->{
            reentrantLock01.add();
        }).start();
        Thread.sleep(1000);
        new Thread(()->{
            reentrantLock01.add();
        }).start();
        Thread.sleep(1000);
        System.out.println(i);
    }

    /**
     * 解锁操作放到finally代码块中
     */
    public void add() {
        try {
            REENTRANT_LOCK.lock();
            for (int j = 0; j<10000; j++) {
                i++;
            }
        } finally {
            REENTRANT_LOCK.unlock();
        }
    }

}
