package com.fuqiang.countdownlatch;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * @author fuqiang
 * @version CallableImpl, v0.1 2018/11/3 10:27
 */
public class CallableImpl implements Callable {

    private CountDownLatch latch;

    public CallableImpl(CountDownLatch latch) {
        this.latch = latch;
    }

    public String doSomeThing() {
        latch.countDown();
        return "一分钟就干完了";
    }

    @Override
    public Object call() throws Exception {
        Thread.sleep(1000);
        return doSomeThing();
    }
}
