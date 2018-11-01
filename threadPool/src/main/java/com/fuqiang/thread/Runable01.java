package com.fuqiang.thread;

public class Runable01 implements Runnable {
    public void run() {
        System.out.println("真好......");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Runable01());
        thread.start();
    }
}
