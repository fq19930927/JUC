package com.fuqiang.atomic.order;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fuqiang
 * @version OrderDemo, v0.1 2018/11/4 23:15
 */
public class OrderDemo {

    static AtomicInteger count = new AtomicInteger(0);

    public String getOrderNo() {
        SimpleDateFormat data = new SimpleDateFormat("YYYYMMDDHHMMSS");
        return data.format(new Date())+count.incrementAndGet();
    }

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(1);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        final OrderDemo orderDemo = new OrderDemo();
        for (int i = 0; i<10; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(orderDemo.getOrderNo());
                }
            });
        }
        latch.countDown();
        executorService.shutdown();
    }

}
