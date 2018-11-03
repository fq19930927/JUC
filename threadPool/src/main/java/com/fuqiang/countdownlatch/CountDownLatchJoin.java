package com.fuqiang.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author fuqiang
 * @version CountDownLatchJoin, v0.1 2018/11/3 10:38
 */
public class CountDownLatchJoin {

	static CountDownLatch countDownLatch = new CountDownLatch(1);

	public static void main(String[] args) throws InterruptedException {
		new Thread(() -> {
			try {
				System.out.println("我在干活");
				Thread.sleep(2000);
				countDownLatch.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		countDownLatch.await();
        System.out.println("我等你干完");
	}
}
