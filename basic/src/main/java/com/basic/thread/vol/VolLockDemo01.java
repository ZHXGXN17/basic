package com.basic.thread.vol;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VolLockDemo01 {
	
	public volatile int inc = 0;
	
	Lock lock = new ReentrantLock();
	
	public void increase() {
		lock.lock();
		try {
			inc++;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		final VolLockDemo01 demo = new VolLockDemo01();
		
		for(int i = 0;i < 10;i++) {
			new Thread() {
				public void run() {
					for(int j = 0;j < 1000;j++) {
						demo.increase();
					}
				}
			}.start();
		}
		
		// 保证前面的线程都执行完
		while(Thread.activeCount() > 1) {
			Thread.yield();
		}
		System.out.println(demo.inc);
	}

}
