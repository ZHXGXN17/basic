package com.basic.thread.cal_fu;

public class MyCallable implements Callable{
	
	private int num;
	
	public MyCallable(int num) {
		this.num = num;
	}

	public Object call() throws Exception {
		int sum = 0;
		for(int i = 1;i <= num;i++) {
			sum += i;
		}
		return sum;
	}
	
	

}
