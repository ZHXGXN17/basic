package com.basic.thread;

public class DeadLockDemo01 {
	
	public static void main(String[] args) {
		Ticket01 t = new Ticket01();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);

        t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        t.flag = false;
        t2.start();
	}

}

class Ticket01 implements Runnable{
	
	private static int num = 100;
	
	Object obj = new Object();
	
	boolean flag = true;
	
	public void run() {
		if(flag) {
			while(true) {
				synchronized(obj) {
					show();
				}
			}
		}else {
			while(true) {
				show();
			}
		}
	}
	
	
	public synchronized void show() {
		synchronized(obj) {
			if(num > 0) {
				try {
					Thread.sleep(100);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "...function..." + num--);
			}
		}
	}
	

}
