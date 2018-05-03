package com.basic.thread.cal_fu;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public interface Future<V> {
	
	boolean cancel(boolean var1);
	
	// 该任务是否已经取消
	boolean isCancelled();
	
	// 判断是否已经完成
	boolean isDone();
	
	// 获取结果，该方法会阻塞
	V get() throws InterruptedException, ExecutionException;
	
	// 获取结果，如果还未完成那么等待，直到timeout或返回结果，该方法会阻塞
	V get(long var1, TimeUnit var3) throws InterruptedException, ExecutionException, TimeoutException;
	
}
