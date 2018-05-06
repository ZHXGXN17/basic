package com.basic.thread.syn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ___一共有3个线程，两个子线程先后循环2次，接着主线程循环3次，接着又回到两 个子线程先后循环2次，再回到主线程又循环3次，如此循环5次。
 * ___思路：老二先执行，执行完唤醒老三，老三执行完唤醒老大，老大执行完唤醒老二，以此循环，所以定义3个Condition对象和一个执行标识即可
 * @author robin
 *
 */
public class ThreeConditionCommunication {
	
	public static void main(String[] args) {
		final Business business = new Business();
		
		// 创建并启动子线程2
		new Thread(new Runnable() {
			public void run() {
				for(int i = 1;i <= 5;i++) {
					business.sub2(i);
				}
			}
		}).start();
		
		// 创建并启动子线程3
		new Thread(new Runnable() {
			public void run() {
				for(int i = 1;i <= 5;i++) {
					business.sub3(i);
				}
			}
		}).start();
		
		for(int i = 1;i <= 5;i++) {
			business.main(i);
		}
		
	}

	static class Business{
		
		Lock lock = new ReentrantLock();
		
		Condition condition1 = lock.newCondition();
		Condition condition2 = lock.newCondition();
		Condition condition3 = lock.newCondition();
		
		// 定义一个变量来决定线程的执行权
		private int shouldSub = 1;
		
		// 线程2
		public void sub2(int i) {
			// 上锁，不允许其他线程执行
			lock.lock();
			try {
				if(shouldSub != 2) {
					try {
						condition2.await();
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				for(int j = 1;j <= 2;j++) {
					System.out.println("sub2 thread sequesnce of " + i + ",loop of " + j);
				}
				// 线程3执行
				shouldSub = 3;
				// 唤醒线程3
				condition3.signal();
			}finally {
				lock.unlock();
			}
		}
		
		// 线程3
		public void sub3(int i) {
			lock.lock();
			try {
				if(shouldSub != 3) {
					try {
						condition3.await();
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				for(int j = 1;j <= 2;j++) {
					System.out.println("sub3 thread sequence of " + i + ",loop of " + j);
				}
				
				// 线程1执行
				shouldSub = 1;
				// 唤醒线程1
				condition1.signal();
			}finally {
				lock.unlock();
			}
		}
		
		// 线程1
		public void main(int i) {
			lock.lock();
			try {
				if(shouldSub != 1) {
					try {
						condition1.await();
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				for(int j = 1;j <= 3;j++) {
					System.out.println("main thread sequence of " + i + ",loop of " + j);
				}
				// 线程2执行
				shouldSub = 2;
				// 唤醒线程2
				condition2.signal();
			}finally {
				lock.unlock();
			}
		}
		
	}
}

