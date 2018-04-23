/*
 ***************************************************************************************
 * All rights Reserved, Designed By www.vic.com.cn
 * @Title:  Example05.java   
 * @Package com.basic.thread   
 * @Description: (用一句话描述该文件做什么)   
 * @author: wangyf
 * @date:   2018年4月22日 上午11:29:12   
 * @version V1.0 
 * @Copyright: 2018 北京vic科技有限责任公司. All rights reserved. 
 * 注意：本内容仅限于公司内部使用，禁止外泄以及用于其他的商业目
 *  ---------------------------------------------------------------------------------- 
 * 文件修改记录
 *     文件版本：         修改人：             修改原因：
 ***************************************************************************************
 */
package com.basic.thread;

public class Example05 {
	
	public static void main(String[] args) {
		// 创建两个线程
		Thread t1 = new YieldThread01("线程A");
		Thread t2 = new YieldThread01("线程B");
		
		t1.start();
		t2.start();
	}

}

class YieldThread01 extends Thread{
	public YieldThread01(String name) {
		super(name);
	}
	
	public void run() {
		for(int i = 0;i < 6;i++) {
			System.out.println(Thread.currentThread().getName() + "------" + i);
			if(i == 3) {
				System.out.println("线程让步:");
				// 线程运行到此，作出让步
				Thread.yield();
			}
		}
	}
}
