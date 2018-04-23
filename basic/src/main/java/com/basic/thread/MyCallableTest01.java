/*
 ***************************************************************************************
 * All rights Reserved, Designed By www.vic.com.cn
 * @Title:  MyCallableTest01.java   
 * @Package com.basic.thread   
 * @Description: (用一句话描述该文件做什么)   
 * @author: wangyf
 * @date:   2018年4月21日 下午5:24:39   
 * @version V1.0 
 * @Copyright: 2018 北京vic科技有限责任公司. All rights reserved. 
 * 注意：本内容仅限于公司内部使用，禁止外泄以及用于其他的商业目
 *  ---------------------------------------------------------------------------------- 
 * 文件修改记录
 *     文件版本：         修改人：             修改原因：
 ***************************************************************************************
 */
package com.basic.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程的实现方式3:
 *    ___A:创建一个线程池对象，控制要创建几个线程对象，public static ExecutorService newFixedThreadPool(int nThreads)
 *    ___B:这种线程池的线程可以执行:可以执行Runnable对象或者Callable对象代表的线程，做一个类实现Runnable接口
 *    ___C:调用如下方法即可Future<?> submit(Runnable task) <T> Future<T> submit(Callable<T> task)
 *    ___D:我就要结束，可以吗？可以
 *
 */
public class MyCallableTest01 {
	
	public static void main(String[] args) {
		// 创建线程池对象
		ExecutorService pool = Executors.newFixedThreadPool(2);
		
		// 可以执行Runnable对象或者Callable对象代表的线程
		pool.submit(new MyCallable());
		pool.submit(new MyCallable());
		
		// 结束
		pool.shutdown();
	}

}

// 这里指定的泛型其实是call()方法的返回值类型
class MyCallable implements Callable{

	public Object call() throws Exception {
		for(int i = 0;i < 100;i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
		return null;
	}
	
}
