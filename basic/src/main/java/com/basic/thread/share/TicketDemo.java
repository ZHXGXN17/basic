package com.basic.thread.share;

public class TicketDemo {
	public static void main(String[] args) {
		//只建立了一个Ticket对象，内存中只有一个tick成员变量，所以是共享数据  
        Ticket01 t = new Ticket01();  

        Thread t1 = new Thread(t);  
        Thread t2 = new Thread(t);  
        Thread t3 = new Thread(t);  
        Thread t4 = new Thread(t);  
        t1.start();  
        t2.start();  
        t3.start();  
        t4.start();  
	}

}

// 卖票类
class Ticket01 implements Runnable{
	
	private int tick = 20;
	
	Object obj = new Object();
	
	public void run() {
		while(true) {
			synchronized(obj) {
				if(tick > 0) {
					System.out.println(Thread.currentThread().getName() + "...sale:" + tick--);
				}
			}
		}
	}
	
}
