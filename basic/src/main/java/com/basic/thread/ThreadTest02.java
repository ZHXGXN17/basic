/*
 ***************************************************************************************
 * All rights Reserved, Designed By www.vic.com.cn
 * @Title:  ThreadTest02.java   
 * @Package com.basic.thread   
 * @Description: (用一句话描述该文件做什么)   
 * @author: wangyf
 * @date:   2018年4月21日 下午5:17:34   
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
 * @author robin
 *
 */
public class ThreadTest02 {
	
	public static void main(String[] args) {
		MyThreadDemo02 d = new MyThreadDemo02();
		// 3、通过Thread类创建线程对象，并将Runnable接口的子类对象作为Thread类的构造函数的参数进行传递
		Thread t1 = new Thread(d);
		Thread t2 = new Thread(d);
		
		t1.start();
		t2.start();
		
	}

}

class MyThreadDemo02 implements Runnable{

	public void run() {
		show();
	}
	
	public void show() {
		for(int i = 0;i < 5;i++) {
			System.out.println(Thread.currentThread().getName() + "..." + i);
		}
	}
	
}
