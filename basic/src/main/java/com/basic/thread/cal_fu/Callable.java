package com.basic.thread.cal_fu;

public interface Callable<V> {
	
	// 返回V类型的结果
	V call() throws Exception;

}
