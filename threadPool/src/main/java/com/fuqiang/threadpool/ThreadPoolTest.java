package com.fuqiang.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author fuqiang
 * @version ThreadPoolTest, v0.1 2018/11/2 9:15
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        /**
         * submit方法底层调用了AbstractExecutorService的execute()方法
         * 区别:
         * 1.submit有返回值,execute没有返回值
         * 2.Task不一样,submit是FutureTask,execute是Task本身  用来执行run方法
         */
        executorService.submit(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println("真好...");
            }
        });
        executorService.shutdown();
    }
}
