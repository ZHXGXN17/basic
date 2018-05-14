package com.basic.thread.synutils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueCommunication {
	
	public static void main(String[] args) {
		
	}
	
	
	/**
	 * 业务类
	 * @author robin
	 *
	 */
	static class Business{
		BlockingQueue<Integer> sub_queue = new ArrayBlockingQueue<Integer>(1);
		BlockingQueue<Integer> main_queue = new ArrayBlockingQueue<Integer>(1);
		
		{
			try {
				// 为了让子队列先走，所以在一开始就往主队列中存入一个对象，使其阻塞
				main_queue.put(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// 子队列先走
		public void sub(int i) {
			
		}
	}

}
