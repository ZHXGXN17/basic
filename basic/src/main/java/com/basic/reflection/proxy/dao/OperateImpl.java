package com.basic.reflection.proxy.dao;

public class OperateImpl implements Operate {

	public void operateMethod1() {
		System.out.println("Invoke operateMethod1");
        sleep(110);
	}

	public void operateMethod2() {
		System.out.println("Invoke operateMethod2");
        sleep(120);
	}

	public void operateMethod3() {
		System.out.println("Invoke operateMethod3");
        sleep(130);
	}
	
	private static void sleep(long millSeconds) {
		try {
			Thread.sleep(millSeconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
