package com.basic.thread.pro_con;

import java.io.Serializable;

public class SetThread01 implements Runnable{
	
	private Student01 s;
	
	private int x = 0;
	
	public SetThread01(Student01 s) {
		this.s = s;
	}
	
	public void run() {
		while(true) {
			synchronized(s) {
				// 判断有没有
				if(s.flag) {
					try {
						// t1等着，释放锁
						s.wait();
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				if(x % 2 == 0) {
					s.name = "张三";
					s.age = 15;
				}else {
					s.name = "李四";
					s.age = 16;
				}
				
				// x = 1;
				x++;
				
				// 修改标记
				s.flag = true;
				// 唤醒线程
				s.notify(); // 唤醒t2，唤醒并不表示立马可以执行，必须还的抢CPU的执行权
			}
			// t1有，或者t2有
		}
	}
}
