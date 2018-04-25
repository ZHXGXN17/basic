package com.basic.thread.vol;

import java.util.concurrent.atomic.AtomicInteger;

public class VolAtomic {

	public AtomicInteger inc = new AtomicInteger();
	
	public void increase() {
		inc.getAndIncrement();
	}
	
	public static void main(String[] args) {
		final VolAtomic demo = new VolAtomic();
		
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
