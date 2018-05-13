package com.basic.thread.synutils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ___1.一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。犹如倒计时计数器，
 *      调用CountDownLatch对象的countDown方法就将计数器减1，当计数到达0时，则所有等待者或单个等待者开始执行
 *      
 * ___2.可以实现一个人（也可以是多个人）等待其他所有人都来通知他，也可以实现一个人通知多个人的效果，
 *      类似裁判一声口令，运动员开始奔跑（一对多），或者所有运送员都跑到终点后裁判才可以公布结果（多对一）
 *      
 * ___3.用指定的计数 初始化 CountDownLatch。在调用 countDown() 方法之前，await 方法会一直受阻塞。
 *      之后，会释放所有等待的线程，await 的所有后续调用都将立即返回。这种现象只出现一次——计数无法被重置。如果需要重置计数，请考虑使用 CyclicBarrier
 * @author robin
 *
 */
public class CountdownLatchTest {
	
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		
		// 构造一个用给定计数初始化的CountDownLatch，相当于裁判的口哨
		final CountDownLatch cdOrder = new CountDownLatch(1);
		
		// 相当于定义3个运动员
		final CountDownLatch cdAnswer = new CountDownLatch(3);
		
		for(int i = 0;i < 3;i++) {
			Runnable runnable = new Runnable() {
				public void run() {
					try {
						System.out.println("线程:" + Thread.currentThread().getName() + "正准备接受命令");
						
						// 等待发令枪
						// 当前线程在锁存器倒计数至零之前一直等待
						cdOrder.await();
						
						// 线程接受命令
						System.out.println("线程:" + Thread.currentThread().getName() + "已经接受命令");
						Thread.sleep((long)(Math.random() * 10000));
						System.out.println("线程" + Thread.currentThread().getName() + "回应命令处理结果");
						
						// 各个运动员报告成绩之后，通知裁判
						// 递减锁存器的计数，如果计数到达零，则释放所有等待的线程
						cdAnswer.countDown();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			
			service.execute(runnable);
		}
		
		// 主线程发布命令
		try {
			Thread.sleep((long)(Math.random() * 10000));
			
			System.out.println("线程" + Thread.currentThread().getName() + "即将发布命令");
			// 发令枪打响，比赛开始
			cdOrder.countDown();
			
			System.out.println("线程" + Thread.currentThread().getName() + "已发送命令，正在等待结果");
			// 裁判等待各个运动员的结果
			cdAnswer.await();
			
			// 裁判公布获得所有运动员的成绩
			System.out.println("线程" + Thread.currentThread().getName() + "已收到所有响应结果");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		service.shutdown();
	}

}
