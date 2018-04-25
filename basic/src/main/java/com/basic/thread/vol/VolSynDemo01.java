package com.basic.thread.vol;

public class VolSynDemo01 {
	public volatile int inc = 0;
	
	public synchronized void increase() {
		inc++;
	}
	
	public static void main(String[] args) {
		
		final VolSynDemo01 demo = new VolSynDemo01();
		
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
