package com.fuqiang.volatiles;

import com.fuqiang.util.TlUtil;

/**
 * synchronized和volatile实验
 * @author fuqiang
 * @version KafkaStart, v0.1 2018/11/2 19:35
 */
public class KafkaStart {
    static volatile boolean isStart = false;

    public synchronized void start() {
        if (isStart) {
            throw new RuntimeException();
        }
        System.out.println("初始完成");
        isStart = true;
    }

    public static void main(String[] args) {
        KafkaStart kafkaStart = new KafkaStart();
        TlUtil.timeTasks(10, 1, new Runnable() {
            @Override
            public void run() {
                kafkaStart.start();
            }
        });
    }

}
