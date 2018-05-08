package com.basic.thread.log;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class LogTest02 {
	
	public static void main(String[] args) {
		/**
		 * 创建一个空间大小为16的阻塞队列，空间大小可以任意，因为每次打印都需要1秒，在此期间，
		 * 4个线程足以不断去从队列中取数据，然后打印，即在1秒内打印4条日志信息
		 */
		final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(16);
		
		// 开启4个线程打印
		for(int i = 0;i < 4;i++) {
			new Thread(new Runnable() {
				public void run() {
					while(true) {
						try {
							// 开始没有数据，阻塞，一旦有其中一个线程就去取数据，即不再阻塞，就开始打印
							String log = queue.take();
							parseLog(log);
						}catch(InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				
			}).start();
		}
		
		// 打印时间秒数
		System.out.println("begin:" + (System.currentTimeMillis() / 1000));
		
		for(int i = 0;i < 16;i++) {
			// 这行代码不能改动
			final String log = "" + (i + 1);
			{
				try {
					// 向队列中存储数据
					queue.put(log);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	// parseLog方法内部的代码不能改动
	public static void parseLog(String log) {
		System.out.println(log + ":" + (System.currentTimeMillis() / 1000));
		
		try {
			// 模拟每条日志打印需要1秒
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
