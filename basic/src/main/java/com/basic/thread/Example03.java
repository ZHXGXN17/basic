/*
 ***************************************************************************************
 * All rights Reserved, Designed By www.vic.com.cn
 * @Title:  Example03.java   
 * @Package com.basic.thread   
 * @Description: (用一句话描述该文件做什么)   
 * @author: wangyf
 * @date:   2018年4月22日 上午10:55:12   
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
 * 线程插队，join()方法的使用
 *
 */
public class Example03 {
	public static void main(String[] args) throws Exception{
		// 创建线程
		Thread t = new Thread(new EmergencyThread(), "线程一");
		t.start();
		
		for(int i = 1;i < 6;i++) {
			System.out.println(Thread.currentThread().getName() + "输出:" + i);
			if(i == 2) {
				t.join();
			}
		}
		
		Thread.sleep(500);
	}
}

class EmergencyThread implements Runnable{

	public void run() {
		for(int i = 1;i < 6;i++) {
			System.out.println(Thread.currentThread().getName() + "输出:" + i);
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
