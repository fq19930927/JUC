package com.fuqiang.thread;

public class Thread01 extends Thread {

    @Override
    public void run() {
        System.out.println("真好...");
    }

    public static void main(String[] args) {
        Thread01 thread01 = new Thread01();
        thread01.start();
    }
}
