package com.basic.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest01 {
	
	public static void main(String[] args) {
		// 创建固定大小的线程池，3个任务
		ExecutorService pool01 = Executors.newFixedThreadPool(3);
		
		// 创建缓存线程池，根据任务自动创建线程的数量，可以完成创建的所有任务
		ExecutorService pool02 = Executors.newCachedThreadPool();
		
		// 创建单一线程池(始终保持线程池中有一个线程存活，当唯一线程死去，会创建新的继任者)
		ExecutorService pool03 = Executors.newSingleThreadExecutor();
		
		for(int i = 0;i < 10;i++) {
			
			// 内部类不能访问外部类的局部变量，所以i要定义为final，又由于i++，所以在循环内部定义一个变量接受i
			final int task = i;
			
			pool01.execute(new Runnable() {

				public void run() {
					for(int j = 1;j <= 10;j++) {
						System.out.println(Thread.currentThread().getName() + " is looping of " + j + " for task of " + task);
					}
				}
				
			});
		}
		
		// 验证10个任务都提交给了线程池
		System.out.println("all of 10 tasks have committed!");
		
		// 等任务完成后，杀死线程
		pool01.shutdown();
		
		// 立即停止线程
		pool01.shutdownNow();
		
		
		//用线程池启动定时器  
		// 用线程池启动定时器
		Executors.newScheduledThreadPool(3).schedule(
				// 任务
				new Runnable() {

					public void run() {
						System.out.println("bombing!");
					}
					
				},
				
				// 5秒以后执行
				5, 
				
				// 时间单位
				TimeUnit.SECONDS);

		// 在某个时间执行一次后，再指定后续的执行间隔时间
		Executors.newScheduledThreadPool(3).scheduleAtFixedRate(
				new Runnable() {

					public void run() {
						System.out.println("bombing");
					}
					
				}, 10, // 第一次在10秒时爆炸
				
				   3, // 以后每隔3秒爆炸一次
				   
				   TimeUnit.SECONDS); // 时间单位
		
	}

}
