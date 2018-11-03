package com.fuqiang.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 等待异步处理结果之后才进行我的操作
 * @author fuqiang
 * @version CountDownLatch02, v0.1 2018/11/3 10:30
 */
public class CountDownLatch02 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        CallableImpl callable = new CallableImpl(countDownLatch);
        FutureTask<String> futureTask = new FutureTask<String>(callable);
        new Thread(futureTask).start();
        if (futureTask.isDone()) {
            try {
                System.out.println("你知道我一直在等你吗>>>>>>");
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(futureTask.get());
    }
}
