package com.fuqiang.syn;

import com.fuqiang.annotation.ThreadNoSafe;

/**
 * 线程安全
 * @author fuqiang
 * @version Sync01, v0.1 2018/11/2 22:30
 */
@ThreadNoSafe
public class Sync02 implements Runnable {
	static int i = 0;

	public void run() {
		add();
	}

	private void add() {
	    synchronized (this) {
            for (int j = 0; j < 100000; j++) {
                i++;
            }
        }
	}

	public static void main(String[] args) throws InterruptedException {
		Sync02 sync01 = new Sync02();
		Sync02 sync02 = new Sync02();

		Thread thread = new Thread(sync01);
		Thread thread2 = new Thread(sync02);
		thread.start();
		thread2.start();
		thread.join();
		thread2.join();
		System.out.println(i);
	}
}
