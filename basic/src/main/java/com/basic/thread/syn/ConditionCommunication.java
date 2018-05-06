package com.basic.thread.syn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionCommunication {
	public static void main(String[] args) {
		final Business business = new Business();
		
		new Thread(
				new Runnable() {
					public void run() {
						for(int i = 1;i <= 5;i++) {
							business.sub(i);
						}
					}
				}).start();
		
		for(int i = 1;i <= 5;i++) {
			business.main(i);
		}
	}
}

// business类
class Business{
	Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();
	
	private boolean bShouldSub = true;
	
	public void sub(int i) {
		lock.lock();
		try {
			while(!bShouldSub) {
				try {
					condition.await();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			for(int j = 0;j <= 1;j++) {
				System.out.println("sub thread sequesnce of " + j + ",loop of "+ i);
			}
			bShouldSub = false;
			condition.signal();
		}finally {
			lock.unlock();
		}
	}
	
	
	// main方法
	public void main(int i) {
		lock.lock();
		try {
			while(bShouldSub) {
				try {
					condition.await();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			for(int j = 1;j <= 4;j++) {
				System.out.println("main thread sequence of " + j + ",loop of " + i);
			}
			
			bShouldSub = true;
			condition.signal();
		}finally {
			lock.unlock();
		}
	}
	
}

