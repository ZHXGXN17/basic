package com.basic.thread.pro_con;

public class GetThread01 implements Runnable{
	
	private Student01 s;
	
	public GetThread01(Student01 s) {
		this.s = s;
	}
	
	public void run() {
		while(true) {
			synchronized(s) {
				if(!s.flag) {
					try {
						// t2等待，立即释放锁
						s.wait();
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				System.out.println(s.name + "----" + s.age);
				
				s.flag = false;
				// 唤醒线程
				s.notify();
				
			}
		}
	}
}
