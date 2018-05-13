/*
 ***************************************************************************************
 * All rights Reserved, Designed By www.zzcx.com.cn
 * @Title:  ThreadCommunicationTest.java   
 * @Package com.basic.thread.synutils   
 * @Description: (用一句话描述该文件做什么)   
 * @author: wangyf
 * @date:   2018-5-12 10:26:57   
 * @version V1.0 
 * @Copyright: 2018  智卓创新(北京)信息产业股份有限公司. All rights reserved. 
 * 注意：本内容仅限于公司内部使用，禁止外泄以及用于其他的商业目
 *  ---------------------------------------------------------------------------------- 
 * 文件修改记录
 *     文件版本：         修改人：             修改原因：
 ***************************************************************************************
 */
package com.basic.thread.synutils;

import java.util.concurrent.Semaphore;

/**
 * ThreadA、ThreadB、ThreadC
 * ___ThreadA用于初始化数据num，只有当num初始化完成后再让ThreadB和ThreadC获取到初始化后的变量num
 * @author robin
 *
 */
public class ThreadCommunicationTest {
	
	/** num. */
	// 定义一个变量作为数据
	private static int num;
	
	/**
	 * 定义一个信号量，该类内部维持了多个线程锁，可以阻塞多个线程，释放多个线程，线程的阻塞和释放是通过permit
	 * 概念来实现的线程通过semaphore.acquire()方法获取permit，如果当前semaphore有permit
	 * 则分配给该线程，如果没有则阻塞该线程直到semaphore调用release()方法释放permit，
	 * 构造函数中参数:permit(允许)个数
	 * @param args
	 */
	private static Semaphore semaphore = new Semaphore(0);
	
	/**
	 * 主函数.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// 线程A
		Thread threadA = new Thread(new Runnable() {
			public void run() {
				// 模拟耗时操作之后初始化变量num
				try {
					Thread.sleep(1000);
					num = 1;
					
					// 初始化完参数后释放两个permit
					semaphore.release(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		// 线程B
		Thread threadB = new Thread(new Runnable() {
			public void run() {
				try {
					// 获取permit，如果semaphore没有可用的permit，则等待  如果有则消耗一个
					semaphore.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println(Thread.currentThread().getName() + "获取到num的值:" + num);
			}
		});
		
		// 线程C
		Thread threadC = new Thread(new Runnable() {
			public void run() {
				try {
					// 获取permit，如果semaphore 没有可用的permit则等待，如果有则消耗一个
					semaphore.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println(Thread.currentThread().getName() + "获取到num的值:" + num);
			}
		});
		
		threadA.start();
		threadB.start();
		threadC.start();
		
	}

}
