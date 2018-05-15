package com.basic.thread.synutils;

import java.util.concurrent.locks.Lock;

public class TwinsLockTest {
	
	public static void main(String[] args) {
		
		final Lock lock = new TwinsLock();
		
		class Worker extends Thread{
			public void run() {
				while(true) {
					lock.lock();
					try {
						Thread.sleep(1000L);
						System.out.println(Thread.currentThread());
						Thread.sleep(1000L);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						lock.unlock();
					}
				}
			}
		}
		
		for(int i = 0;i < 10;i++) {
			Worker worker = new Worker();
			worker.start();
		}
		
		new Thread() {
			public void run() {
				while(true) {
					try {
						Thread.sleep(200L);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		
		try {
			Thread.sleep(20000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
