package com.basic.thread.syn;

public class MyBlockTest {
	
	public static void main(String[] args) {
		MyArrayBlockingQueue<Integer> aQueue = new MyArrayBlockingQueue<Integer>();
		
//		aQueue.put(3);
		aQueue.put(24);
		
		for(int i = 0;i < 5;i++) {
			System.out.println(aQueue.take());
		}
	}

}
