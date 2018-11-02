package com.fuqiang.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadPK {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        /**
         * 匿名内部类中的形参只能是final修饰
         * 原因:1.得到的参数实际上是拷贝来的
         * 2.防止不能同步修改
         */
        final List<Integer> l = new ArrayList<Integer>();
        final Random random = new Random();
        for (int i = 0;i<100000;i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    l.add(random.nextInt());
                }
            };
            thread.start();
            // 通过主线程等待的方式使线程有序执行  底层是Object的wait方法
            thread.join();
        }
        System.out.println(System.currentTimeMillis()-start);
        System.out.println(l.size());
    }
}
