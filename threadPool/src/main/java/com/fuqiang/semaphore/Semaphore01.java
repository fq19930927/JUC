package com.fuqiang.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author fuqiang
 * @version Semaphore01, v0.1 2018/11/3 10:56
 */
public class Semaphore01 {

    private static Semaphore semaphore = new Semaphore(5);

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            final int j = i;
            new Thread(()-> {
                try {
                    action(j);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }


    public static void action(int i) throws InterruptedException {
        semaphore.acquire();
        System.out.println(i + "在京东秒杀iphonex");
        Thread.sleep(3000);
        System.out.println(i + "秒杀成功");
        semaphore.release();
    }
}
