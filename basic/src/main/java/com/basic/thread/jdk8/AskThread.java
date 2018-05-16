package com.basic.thread.jdk8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AskThread implements Runnable{

	CompletableFuture<Integer> re = null;
	
	// 构造方法
	public AskThread(CompletableFuture re){
		this.re = re;
	}
	
	// 重写run方法
	public void run() {
		int myRe = 0;
		try {
			myRe = re.get() * re.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(myRe);
	}
	
	public static void main(String[] args) throws InterruptedException {
		final CompletableFuture<Integer> future = new CompletableFuture<Integer>(); 
		new Thread(new AskThread(future)).start();
		
		// 模拟长时间的计算过程
		Thread.sleep(1000);
		// 告知完成结果
		future.complete(60);
	}
	

}
