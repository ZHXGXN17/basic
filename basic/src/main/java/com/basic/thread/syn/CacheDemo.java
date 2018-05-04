package com.basic.thread.syn;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheDemo {
	
	// 定义一个map用于缓存对象
	private Map<String, Object> cache = new HashMap<String, Object>();
	
	// 获取一个读写锁对象
	private ReadWriteLock rwl = new ReentrantReadWriteLock();
	
	// 带有缓存的获取指定值的方法
	public Object getData(String key) {
		// 上读锁
		rwl.readLock().lock();
		Object value = null;
		try {
			// 获取要查询的值
			value = cache.get(key);
			// 判断线程出现安全问题的地方
			if(value == null) {
				// 没有数据，释放读锁，上写锁
				rwl.readLock().unlock();
				// 多个线程去上写锁，第一个成功后，其他线程阻塞，第一个线程开始执行下面的代码，最后
				// 释放写锁后，后面的线程继续上写锁，为了避免后面的线程重复写入，进行二次判断
				rwl.writeLock().lock();
				try {
					// 二次判断，放置其它线程重复写数据
					if(value == null) {
						// 实际是去查询数据库
						value = "aaaa";
					}
				}finally {
					// 写完数据，释放写锁
					rwl.writeLock().unlock();
				}
				// 恢复读锁
				rwl.readLock().lock();
			}
		}finally {
			rwl.readLock().unlock();
		}
		return value;
	}

}
