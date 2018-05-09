package com.basic.thread.synutils;

import java.util.concurrent.Semaphore;

/**
 * 控制一个方法的并发量，比如同时只允许有3个线程进来
 * @author robin
 *
 */
public class ThreadPoolTest {

	// 信号量, 允许个数，相当于放了3把锁
	private static Semaphore semaphore = new Semaphore(3);
	
	public static void main(String[] args) {
		for(int i = 0;i < 10;i++) {
			new Thread(new Runnable() {

				public void run() {
					try {
						method();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}).start();
		}
	}
	
	/**
	 * 同时最多只允许3个线程过来
	 * @throws InterruptedException 
	 */
	public static void method() throws InterruptedException{
		// 获取一把锁
		semaphore.acquire();
		
		System.out.println("ThreadName = " + Thread.currentThread().getName() + "过来了");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("ThreadName = " + Thread.currentThread().getName() + "出去了");
		semaphore.release();
	}
}
