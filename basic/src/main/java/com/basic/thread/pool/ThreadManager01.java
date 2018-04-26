package com.basic.thread.pool;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadManager01 {
	
	public static final String DEFAULT_SINGLE_POOL_NAME = "DEFAULT_SINGLE_POOL_NAME";
	
	private static ThreadPoolProxy mLongPool = null;
	private static Object mLongLock = new Object();
	
	private static ThreadPoolProxy mShortPool = null;
	private static Object mShortLock = new Object();
	
	private static ThreadPoolProxy mDownloadPool = null;
	private static Object mDownloadLock = new Object();
	
	private static Map<String, ThreadPoolProxy> mMap = new HashMap<String, ThreadPoolProxy>();
	private static Object mSingleLock = new Object();
	
	
	public static ThreadPoolProxy getDownloadPool() {
		synchronized(mDownloadLock) {
			if(mDownloadPool == null) {
				mDownloadPool = new ThreadPoolProxy(3, 3, 5L);
			}
			
			return mDownloadPool;
		}
	}
	
	
	/**
	 * 获取一个用于执行长耗时任务的线程池，避免和短耗时任务处在同一个队列而阻塞了重要的短耗时任务，通常用来联网操作
	 */
	public static ThreadPoolProxy getLongPool() {
		synchronized(mLongLock) {
			if(mLongPool == null) {
				mLongPool = new ThreadPoolProxy(5, 5, 5L);
			}
			return mLongPool;
		}
	}
	
	
	/**
	 * 获取一个用于执行短耗时任务的线程池，避免因为和耗时长的任务处在同一个队列而长时间得不到执行，通常用来执行本地的IO、SQL
	 */
	public static ThreadPoolProxy getShortPool() {
		synchronized(mShortLock) {
			if(mShortPool == null) {
				mShortPool = new ThreadPoolProxy(2, 2, 5L);
			}
			return mShortPool;
		}
	}
	
	
	

}

