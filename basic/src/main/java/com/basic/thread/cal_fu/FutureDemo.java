package com.basic.thread.cal_fu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FutureDemo {
	
	// 线程池
	static ExecutorService mExecutor = Executors.newSingleThreadExecutor();
	
	public static void main(String[] args) {
		
	}
	
	
	/**
	 * 其中Runnable实现的是void run()方法，无返回值，Callable实现的是V call()方法，并且可以
	 * 返回执行结果，其中Runnable可以提交给Thread来包装下，直接启动一个线程来执行，而Callable则一般
	 * 都是提交给ExecuteService来执行
	 */
//	private static void futureWithRunnable() throws InterruptedException, ExecutionException{
		// 提交runnable则没有返回值，future没有数据
//		Future<?> result = mExecutor.submit(new Runnable() {
//			public void run() {
//				fibc(20);
//			}
//		});
		
//		System.out.println("future result from runnable:" + result.get());
//	}
	

}
