package com.basic.thread.syn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer {
	
	final Lock lock = new ReentrantLock();
	
	final Condition notFull = lock.newCondition();
	
	final Condition notEmpty = lock.newCondition();
	
	final Object[] items = new Object[100];
	
	int putptr, takeptr, count;
	
	public void put(Object obj) throws InterruptedException{
		lock.lock();
		try {
			// 循环判断队列是否已存满
			while(count == items.length) {
				// 如果队列存满了，则要存入数据的线程等待
				notFull.await();
			}
			items[putptr] = obj;
			if(++putptr == items.length) {
				// 当队列放满，指针回到0
				putptr = 0;
			}
			// 添加了一个数据
			++count;
			// 队列中有数据了，所以就唤醒取数据的线程
			notEmpty.signal();
		}finally {
			lock.unlock();
		}
	}
	
	
	public Object take() throws InterruptedException{
		lock.lock();
		try {
			// 循环判断，队列是否有空位
			while(count == 0) {
				// 要取的线程等待
				notEmpty.await();
			}
			Object obj = items[takeptr];
			if(++takeptr == items.length) {
				takeptr = 0;
			}
			// 取走一个，说明队列有空闲的位置
			--count;
			// 所以通知存入的线程
			notFull.signal();
			return obj;
		}finally {
			lock.unlock();
		}
	}
	
}
