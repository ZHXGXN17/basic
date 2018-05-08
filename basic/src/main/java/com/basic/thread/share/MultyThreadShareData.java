package com.basic.thread.share;

public class MultyThreadShareData {
	public static void main(String[] args) {
		// 定义final类型的局部变量
		final ShareData data = new ShareData();
		
		// 开启4条线程
		for(int i = 0;i < 2;i++) {
			// 增加的线程
			new Thread(new Runnable() {
				public void run() {
					for(int i = 0;i < 10;i++) {
						data.increment();
					}
				}
			}).start();
			
			// 减少的线程
			new Thread(new Runnable() {
				public void run() {
					for(int i = 0;i < 10;i++) {
						data.decrement();
					}
				}
			}).start();
		}
		
		
	}

}

/**
 * 封装共享数据和操作共享数据方法的类
 */
class ShareData{
	private int j = 0;
	
	public synchronized void increment() {
		j++;
		System.out.println(Thread.currentThread().getName() + "----inc:" + j);
	}
	
	public synchronized void decrement() {
		j--;
		System.out.println(Thread.currentThread().getName() + "----dec:" + j);
	}
}
