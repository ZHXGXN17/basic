/*
 ***************************************************************************************
 * All rights Reserved, Designed By www.vic.com.cn
 * @Title:  Example02.java   
 * @Package com.basic.thread   
 * @Description: (用一句话描述该文件做什么)   
 * @author: wangyf
 * @date:   2018年4月22日 上午10:45:44   
 * @version V1.0 
 * @Copyright: 2018 北京vic科技有限责任公司. All rights reserved. 
 * 注意：本内容仅限于公司内部使用，禁止外泄以及用于其他的商业目
 *  ---------------------------------------------------------------------------------- 
 * 文件修改记录
 *     文件版本：         修改人：             修改原因：
 ***************************************************************************************
 */
package com.basic.thread;

public class Example02 {
	
	public static void main(String[] args) {
		Worker worker1 = new Worker("work-1");
		Worker worker2 = new Worker("work-2");
		
		worker1.start();
		System.out.println("启动线程1");
		try {
			worker1.join();
			System.out.println("启动线程2");
			worker2.start();
			worker2.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("主线程继续执行");
	}

}

class Worker extends Thread{
	
	public Worker(String name) {
		super(name);
	}
	
	public void run() {
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("work in" + getName());
	}
}
