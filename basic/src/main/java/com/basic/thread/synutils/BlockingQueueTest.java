package com.basic.thread.synutils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
	
	public static void main(String[] args) {
		// 定义3个空间的队列来演示向阻塞队列中存取数据的效果
		final BlockingQueue queue = new ArrayBlockingQueue(3);
		
		for(int i = 0;i < 3;i++) {
			new Thread() {
				public void run() {
					while(true) {
						try {
							Thread.sleep((long)(Math.random() * 1000));
							System.out.println(Thread.currentThread().getName() + "准备放数据");
							// 存数据后，可能立即执行"准备取数据"
							queue.put(1);
							System.out.println(Thread.currentThread().getName() + "已经放了数据，队列目前有" + queue.size() + "个数据");
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}.start();
			
			
			new Thread() {
				public void run() {
					while(true) {
						try {
							// 将此处的睡眠时间分别改为100和1000，观察运行结果
							Thread.sleep(10000);
							System.out.println(Thread.currentThread().getName() + "准备取数据");
							// 取出后可能來不及执行下面的打印语句，就跑到了“准备放数据”
							queue.take();
							System.out.println(Thread.currentThread().getName() + "已经取走数据，队列目前有" + queue.size() + "个数据");
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}.start();
		}
		
	}

}
