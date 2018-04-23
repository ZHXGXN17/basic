/*
 ***************************************************************************************
 * All rights Reserved, Designed By www.vic.com.cn
 * @Title:  Example04.java   
 * @Package com.basic.thread   
 * @Description: (用一句话描述该文件做什么)   
 * @author: wangyf
 * @date:   2018年4月22日 上午11:09:12   
 * @version V1.0 
 * @Copyright: 2018 北京vic科技有限责任公司. All rights reserved. 
 * 注意：本内容仅限于公司内部使用，禁止外泄以及用于其他的商业目
 *  ---------------------------------------------------------------------------------- 
 * 文件修改记录
 *     文件版本：         修改人：             修改原因：
 ***************************************************************************************
 */
package com.basic.thread;

public class Example04 {
	
	public static void main(String[] args) {
		YieldThread t1 = new YieldThread("thread-1");
		YieldThread t2 = new YieldThread("thread-2");
		
		t1.start();
		t2.start();
	}

}

class YieldThread extends Thread{
	
	public YieldThread(String name) {
		super(name);
	}
	
	public synchronized void run() {
		for(int i = 0;i < 5;i++) {
			System.out.printf("%s,优先级为:%d-----> %d\n", this.getName(), this.getPriority(), i);
			// i整除4时，调用yield
			if(i == 2) {
				Thread.yield();
			}
		}
	}
}
