package com.basic.thread;

public class TicketDemo01 {
	
	public static void main(String[] args) {
		// 通过Thread类创建线程对象，并将Runnable接口的子类对象作为Thread类的构造函数的参数进行传递。
        Ticket t = new Ticket();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        Thread t4 = new Thread(t);
        
        // 调用线程对象的start方法开启线程。
        t1.start();
        t2.start();
        t3.start();
        t4.start();
	}

}

// 卖票程序的同步代码块实现示例
class Ticket implements Runnable{
	
	private int num = 10;
	
	Object obj = new Object();

	public void run() {
		while(true) {
			// 给可能出现问题的代码加锁
			synchronized(obj) {
				if(num > 0) {
					// 显示线程名及余票数
					System.out.println(Thread.currentThread().getName() + "...sale..." + num--);
				}
			}
		}
	}
	
}