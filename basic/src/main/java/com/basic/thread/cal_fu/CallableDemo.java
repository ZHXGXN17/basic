package com.basic.thread.cal_fu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallableDemo {
	
	ExecutorService pool = Executors.newFixedThreadPool(2);
	
//	Future<Integer> future = pool.submit(new SumCallable(10));
	
//	Integer sum = future.get();
	
	
	
	class SumCallable implements Callable<Integer>{
		
		private int number;
		
		public SumCallable(int number) {
			this.number = number;
		}

		public Integer call() throws Exception {
			int sum = 0;
			for(int i = 0;i < number;i++) {
				sum += i;
			}
			return sum;
		}
		
	}
	
}
