package com.basic.thread.log;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

/**
 * semaphore与synchronousQueue的混合使用
 * 由于Semaphore只有一个许可权，所以谁先拿到谁执行，然后释放，
 * 保证依次执行，只要保证一个线程执行即可
 * SynchronousQueue是必须有其他线程取的动作，这样一一动作
 * @author robin
 *
 */
public class TestDo02 {
	
	public static void main(String[] args) {
		// 定义一个许可权为1的信号灯
		final Semaphore semaphore = new Semaphore(1);
		
		// 产生的结果无序
		final SynchronousQueue<String> queue = new SynchronousQueue<String>();
		
		// 开启10个线程
		for(int i = 0;i < 10;i++) {
			new Thread(new Runnable() {
				public void run() {
					try {
						// 获取许可
						semaphore.acquire();
						String input = queue.take();
						String output = TestDo2.doSome(input);
						System.out.println(Thread.currentThread().getName() + ":" + output);
						// 释放许可
						semaphore.release();
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}
	
}

// 不能改动此TestDo类
class TestDo2{
	public static String doSome(String input) {
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		String output = input + ":" + (System.currentTimeMillis() / 1000);
		return output;
	}
}
