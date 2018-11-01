package com.fuqiang.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Callable01 implements Callable<String> {
    public String call() throws Exception {
        return "真好......";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new Callable01());
        /**
         * 会调用FutureTask的run方法,里面会调用Callable01的call方法
         *           调用set()方法
         *          然后把线程的NEW状态改为COMPLETING状态
         */
        new Thread(futureTask).start();
        /**
         * get方法会产生阻塞,会一直等到任务执行完毕才返回
         */
        System.out.println(futureTask.get());
    }
}
