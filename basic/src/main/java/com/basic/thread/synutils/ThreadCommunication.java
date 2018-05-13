package com.basic.thread.synutils;

public class ThreadCommunication {
	
	// 定义一个变量作为数据
	private static int num;
	
	public static void main(String[] args) {
		// 线程A
		Thread threadA = new Thread(new Runnable() {
			
			public void run() {
				// 模拟耗时操作之后初始化变量num
				try {
					Thread.sleep(1000);
					num = 1;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		// 线程B
		Thread threadB = new Thread(new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + "获取num的值为:" + num);
			}
		});
		
		// 线程C
		Thread threadC = new Thread(new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + "获取num的值为" + num);
			}
		});
		
		// 同时启动3个线程
		threadA.start();
		threadB.start();
		threadC.start();
		
	}
	

}
