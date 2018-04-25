package com.basic.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

public class ThreadPoolProxy {
		
	private ThreadPoolExecutor mPool;
	
	private int mCorePoolSize;
	
	private int mMaximumPoolSize;
	
	private long mKeepAliveTime;
	
	public ThreadPoolProxy() {
		super();
	}


	public ThreadPoolProxy(int corePoolSize, int maximumPoolSize, long keepAliveTime) {
        mCorePoolSize = corePoolSize;
        mMaximumPoolSize = maximumPoolSize;
        mKeepAliveTime = keepAliveTime;
    }
	
	
	/**
	 * 执行任务，当线程池处于关闭，将会重新创建新的线程池
	 */
	public synchronized void execute(Runnable run) {
		if(run == null) {
			return;
		}
		
		if(mPool == null || mPool.isShutdown()) {
			/**
			 * 参数说明
			 * ___当线程池中的线程小于mCorePoolSize，直接创建新的线程加入线程池执行任务
			 * ___当线程池中的线程数目等于mCorePoolSize，将会把任务放入任务队列BlockingQueue
			 * ___当BlockingQueue中的任务放满了，将会创建新的线程去执行
			 * ___但是当总线程数大于mMaximumPoolSize时，将会抛出异常，交给RejectedExecutionHandler处理
			 * ___mKeepAliveTime是线程执行完任务后，且队列中没有可以执行的任务，搓火的时间，后面的参数是时间单位
			 * ___ThreadFactory是每次创建新的线程工厂
			 */
			mPool = new ThreadPoolExecutor(mCorePoolSize, mMaximumPoolSize, 
					mKeepAliveTime, TimeUnit.MILLISECONDS, 
					new LinkedBlockingQueue<Runnable>(), 
					Executors.defaultThreadFactory(), new AbortPolicy());
		}
		
		mPool.execute(run);
	}
	

	
}
