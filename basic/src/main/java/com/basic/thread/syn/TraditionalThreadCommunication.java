package com.basic.thread.syn;

/**
 * 需求:子线程循环10次，接着主线程循环100次，接着又回到子线程循环10次，接着再回到主线程又循环100次，如此循环50次
 * @author robin
 *
 */
public class TraditionalThreadCommunication {
	public static void main(String[] args) {
		// 获取一个业务对象
		final Business01 business = new Business01();
		
		// 子线程
		new Thread(new Runnable() {

			public void run() {
				for(int i = 1;i <= 50;i++) {
					business.sub(i);
				}
			}
			
		}).start();
		
		// 主线程
		for(int i = 1;i <= 50;i++) {
			business.main(i);
		}
	}

}

/**
 * 定义一个业务类
 */
class Business01{
	// 定义一个boolean型变量来决定子线程和主线程的执行权
	private boolean bShouldSub = true;
	
	// 子线程,同步的锁放在资源上
	public synchronized void sub(int i) {
		// 不该子线程执行，等待
		if(!bShouldSub) {
			try {
				this.wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// 子线程执行任务
		for(int j = 1;j <= 10;j++) {
			System.out.println("sub thread sequence of " + i + ",loop of" + j);
		}
		bShouldSub = false;
		
		// 唤醒主线程
		this.notify();
	}
	
	// 主线程
	public synchronized void main(int i) {
		// 若是子线程执行，则主线程等待
		if(bShouldSub) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// 主线程执行任务
		for(int j = 1;j <= 100;j++) {
			System.out.println("main thread sequence of " + i + ",loop of" + j);
		}
		bShouldSub = true;
		// 唤醒子线程
		this.notify();
	}
}

