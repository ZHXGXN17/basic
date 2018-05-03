package com.basic.thread.cal_fu;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class RunnableFutureTask {
	
	/**
	 * ExecutorService
	 */
	static ExecutorService mExecutor = Executors.newSingleThreadExecutor();
	
	public static void main(String[] args) {
		runnableDemo();
		futureDemo();
	}
	
	
	/**
	 * runnable,无返回值
	 */
	static void runnableDemo() {
		new Thread(new Runnable() {
			public void run() {
				System.out.println("runnable demo:" + fibc(20));
			}
		}).start();
	}

	/**
	 * 其中Runnable实现的是void run()方法，无返回值，Callable实现的是V call()方法，
	 * 并且可以返回执行结果，其中Runnable可以提交给Thread来包装下，直接启动一个线程来执行，而
	 * Callable则一般都是提交给ExecuteService来执行
	 */
	static void futureDemo() {
		try {
			// 提交runnable则没有返回值, future没有数据
			Future<?> result = mExecutor.submit(new Runnable() {
				public void run() {
					fibc(20);
				}
			});
			
			System.out.println("future result from runnable:" + result.get());
			
			Future<Integer> result2 = mExecutor.submit(new Callable<Integer>() {
				public Integer call() throws Exception{
					return fibc(20);
				}
			});
			
			System.out.println("future result from callable:" + result2.get());
			
			/**
			 * FutureTask则是一个RunnableFuture<V>,即实现了Runnable又实现了Future<V>这两个接口，
			 * 另外它还可以包装Runnable(实际上会转换为Callable)和Callable<V>.所以一般来讲是一个符合体了，
			 * 它可以通过Thread包装来直接执行，也可以提交给ExecuteService来执行，并且还可以通过v get()返回
			 * 执行结果，在线程体没有执行完成的时候，主线程一直阻塞等待，执行完则直接返回结果。
			 */
			FutureTask<Integer> futureTask = new FutureTask<Integer>(
					new Callable<Integer>() {
						public Integer call() throws Exception{
							return fibc(20);
						}
					});
			
			// 提交futureTask  
            mExecutor.submit(futureTask) ;  
            System.out.println("future result from futureTask:" + futureTask.get()); 
		}catch(InterruptedException e) {
			e.printStackTrace();
		}catch(ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 效率低下的斐波那契数列，耗时的操作
	 */
	/**
	 * 效率低下的斐波那契数列，耗时的操作
	 * @param num
	 * @return
	 */
	static int fibc(int num) {
		if(num == 0) {
			return 0;
		}
		if(num == 1) {
			return 1;
		}
		return fibc(num - 1) + fibc(num - 2);
	}


}
