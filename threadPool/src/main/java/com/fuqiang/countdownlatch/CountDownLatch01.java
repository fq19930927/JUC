package com.fuqiang.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author fuqiang
 * @version CountDownLatch01, v0.1 2018/11/3 9:20
 */
public class CountDownLatch01 {

    private final static int threadCount = 100;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        /**
         * threadCount表示线程要等待的操作数
         *
         * CountDownLatch  是一次性的，只能通过构造方法设置初始计数量，计数完了无法进行复位，不能达到复用。
         */
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i<threadCount; i++) {
            executorService.execute(()->{
                try {
                    test(threadCount);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 构造参数的操作减1
                    countDownLatch.countDown();
                }
            });
        }
        // 阻塞当前线程
        countDownLatch.await(120, TimeUnit.MILLISECONDS);
        System.out.println("结束");
        executorService.shutdown();
    }

    private static void test(int threadCount) throws InterruptedException {
        Thread.sleep(50);
        System.out.println(threadCount);
        Thread.sleep(50);
    }
}
