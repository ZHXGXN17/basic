package com.basic.thread.log;

public class LogTest01 {
	
	public static void main(String[] args) {
		System.out.println("begin:" + (System.currentTimeMillis() / 1000));
		
		/**
		 * 模拟处理16行日志，下面的代码产生了16个日志对象，当前代码需要运行16秒才能打印这些日志，
		 * 修改程序代码，开四个线程让这16个对象在4秒内打完
		 */
		for(int i = 0;i < 16;i++) {
			final String log = "" + (i + 1);
			{
				LogTest01.parseLog(log);
			}
		}
	}
	
	
	// parseLog方法内部的代码不能动
	public static void parseLog(String log) {
		System.out.println(log + ":" + (System.currentTimeMillis() / 1000));
		
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
