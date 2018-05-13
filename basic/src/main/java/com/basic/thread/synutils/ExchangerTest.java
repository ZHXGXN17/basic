package com.basic.thread.synutils;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerTest {

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		
		final Exchanger exchanger = new Exchanger();
		
		service.execute(new Runnable() {
			public void run() {
				try {
					String data1 = "毒品";
					System.out.println("线程" + Thread.currentThread().getName() + "正在把:" + data1 + "   交易出去");
					Thread.sleep((long)(Math.random() * 10000));
					String data2 = (String)exchanger.exchange(data1);
					
					System.out.println("线程" + Thread.currentThread().getName() + "换得了:" + data2);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		service.execute(new Runnable() {
			public void run() {
				try {
					String data1 = "美金$";
					System.out.println("线程" + Thread.currentThread().getName() + "正在把：" + data1 + "   交换出去");
					Thread.sleep((long)(Math.random() * 10000));
					
					String data2 = (String)exchanger.exchange(data1);
					System.out.println("线程" + Thread.currentThread().getName() + "换得了" + data2);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
