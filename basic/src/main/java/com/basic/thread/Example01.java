/*
 ***************************************************************************************
 * All rights Reserved, Designed By www.vic.com.cn
 * @Title:  Example01.java   
 * @Package com.basic.thread   
 * @Description: (用一句话描述该文件做什么)   
 * @author: wangyf
 * @date:   2018年4月22日 上午10:33:37   
 * @version V1.0 
 * @Copyright: 2018 北京vic科技有限责任公司. All rights reserved. 
 * 注意：本内容仅限于公司内部使用，禁止外泄以及用于其他的商业目
 *  ---------------------------------------------------------------------------------- 
 * 文件修改记录
 *     文件版本：         修改人：             修改原因：
 ***************************************************************************************
 */
package com.basic.thread;

public class Example01 {
	public static void main(String[] args) throws Exception{
		// 创建一个线程
		new Thread(new Task()).start();
		
		for(int i = 1;i <= 10;i++) {
			if(i == 5) {
				Thread.sleep(2000);
			}else {
				Thread.sleep(500);
			}
			System.out.println("main主线程正在输出:" + i);
		}
	}

}

// 定义线程的任务类
class Task implements Runnable{
	public void run() {
		for(int i = 1;i <= 10;i++) {
			try {
				if(i == 3) {
					// 当前线程休眠2秒
					Thread.sleep(2000);
				}else {
					Thread.sleep(500);
				}
				System.out.println("线程一正在输出:" + i);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
