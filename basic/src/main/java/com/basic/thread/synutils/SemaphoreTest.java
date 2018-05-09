package com.basic.thread.synutils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	public static void main(String[] args) {
		// 创建一个可以根据需要创建新线程的线程池
		ExecutorService service = Executors.newCachedThreadPool();
		
		final Semaphore sp = new Semaphore(3);
		
		for(int i = 0;i < 10;i++) {
			Runnable runnable = new Runnable() {
				public void run() {
					// 获取许可权限
					try {
						sp.acquire();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					// 由于new Semaphore(3)设置为3
					System.out.println("线程" + Thread.currentThread().getName() + "进入，当前已有"
							+ (3 - sp.availablePermits() + "个并发"));
					
					try {
						Thread.sleep((long)(Math.random() * 10000));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println("线程" + Thread.currentThread().getName() + "即将离开");
					// 释放许可，将其返回一个信号量
					sp.release();
					
					// 下面代码有时候执行不准确，因为其没有和上面的代码合成原子单元
					System.out.println("线程" + Thread.currentThread().getName() + "已离开，当前已有" + (3 - sp.availablePermits() + "个并发"));
				}
			};
			
			service.execute(runnable);
		}
	}

}
