package com.basic.thread.syn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用ReentrantLock和Condition实现一个简单的阻塞队列MyArrayBlockingQueue,
 * 如果调用take方法时集合中没有数据，那么调用线程就阻塞，如果调用put方法时，集合数据已满，那么
 * 也会引起调用线程阻塞。但是，这两个阻塞的条件是不同的，分别为notFull和notEmpty
 * @author robin
 * @param <T>
 */
public class MyArrayBlockingQueue<T> {
	
	/** 数据数组. */
	private final T[] items;
	
	/** 锁. */
	private final Lock lock = new ReentrantLock();
	
	/** 队列满的条件. */
	private Condition notFull = lock.newCondition();
	
	/** 队空的条件. */
	private Condition notEmpty = lock.newCondition();
	
	/** 头部索引. */
	private int head;
	
	/** 尾部索引. */
	private int tail;
	
	/** 数据的个数. */
	private int count;
	
	public MyArrayBlockingQueue(int maxSize) {
		items = (T[])new Object[maxSize];
	}
	
	public MyArrayBlockingQueue() {
		this(10);
	}
	
	public void put(T t) {
		lock.lock();
		try {
			while(count == getCapacity()) {
				System.out.println("数据已满，等待......");
				notFull.await();
			}
			items[tail] = t;
			if(++tail == getCapacity()) {
				tail = 0;
			}
			
			++count;
			// 唤醒等待数据的线程
			notEmpty.signalAll();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	public T take() {
		lock.lock();
		try {
			while(count == 0) {
				System.out.println("还没有数据，请等待.....");
				notEmpty.await();
			}
			
			T ret = items[head];
			items[head] = null;
			
			if(++head == getCapacity()) {
				head = 0;
			}
			
			--count;
			// 唤醒添加数据的线程
			notFull.signalAll();
			return ret;
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		return null;
	}
	
	public int getCapacity() {
		return items.length;
	}
	
	public int size() {
		lock.lock();
		try {
			return count;
		}finally {
			lock.unlock();
		}
	}
	
}
