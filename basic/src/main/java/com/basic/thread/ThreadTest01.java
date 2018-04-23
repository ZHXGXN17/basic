/*
 ***************************************************************************************
 * All rights Reserved, Designed By www.vic.com.cn
 * @Title:  ThreadTest01.java   
 * @Package com.basic.thread   
 * @Description: (用一句话描述该文件做什么)   
 * @author: wangyf
 * @date:   2018年4月21日 下午5:04:49   
 * @version V1.0 
 * @Copyright: 2018 北京vic科技有限责任公司. All rights reserved. 
 * 注意：本内容仅限于公司内部使用，禁止外泄以及用于其他的商业目
 *  ---------------------------------------------------------------------------------- 
 * 文件修改记录
 *     文件版本：         修改人：             修改原因：
 ***************************************************************************************
 */
package com.basic.thread;

/**
 * 多线程的实现方案一：继承Thread类，重写run()方法
 *
 */
public class ThreadTest01 {
	
	public static void main(String[] args) {
		// 3、直接创建Thread的子类对象创建线程
		MyThreadDemo01 d1 = new MyThreadDemo01("黑马程序员");
		MyThreadDemo01 d2 = new MyThreadDemo01("中关村在线");
		// 4、调用start方法开启线程并调用线程的任务run方法执行
		d1.start();
		d2.start();
		
		for(int i = 0;i < 5;i++) {
			System.out.println("i = " + i + "...over..." + Thread.currentThread().getName());
		}
	}

}

class MyThreadDemo01 extends Thread{
	
	private String name;
	
	MyThreadDemo01(String name){
		this.name = name;
	}
	
	public void run() {
		for(int i = 0;i < 5;i++) {
			System.out.println(name + "...i = " + i + "...ThreadName = " + Thread.currentThread().getName());
		}
	}
}
