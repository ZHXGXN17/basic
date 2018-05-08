package com.basic.thread.share;

public class MultyThreadShareMethod1 {
	public static void main(String[] args) {
		// 将数据封装到一个对象上
		ShareData2 data1 = new ShareData2();
		
		// 在Runnable的构造函数直接传入去操作
		for(int i = 0;i < 2;i++) {
			new Thread(new MyRunnable1(data1)).start();
			new Thread(new MyRunnable2(data1)).start();
		}
	}

}

/**
 * 封装共享数据和操作共享数据方法的类
 */
class ShareData2{
	private int j = 10;
	
	public synchronized void increment() {
		j++;
		System.out.println(Thread.currentThread().getName() + "----inc:" + j);
	}
	
	public synchronized void decrement() {
		j--;
		System.out.println(Thread.currentThread().getName() + "----dec:" + j);
	}
}

/**
 * 增加的线程，需要传入一个共享数据
 */
class MyRunnable1 implements Runnable{
	private ShareData2 data;
	
	public MyRunnable1(ShareData2 data) {
		this.data = data;
	}
	
	public void run() {
		for(int i = 0;i < 10;i++) {
			data.increment();
		}
	}
}

/**
 * 减少的线程，需要传入一个共享数据
 */
class MyRunnable2 implements Runnable{
	private ShareData2 data;
	
	public MyRunnable2(ShareData2 data) {
		this.data = data;
	}
	
	public void run() {
		for(int i = 0;i <10;i++) {
			data.increment();
		}
	}
}
