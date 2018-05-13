package com.basic.thread.synutils;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CyclicBarrier允许一组线程互相等待，直到到达某个公共屏障点(common barrier point)
 * @author robin
 *
 */
public class CyclicBarrierTest {

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		
		final CyclicBarrier cb = new CyclicBarrier(3);
		
		// 循环
		for(int i = 0;i < 3;i++) {
			Runnable run = new Runnable() {
				public void run() {
					try {
						Thread.sleep((long)(Math.random() * 10000));
						System.out.println("线程" + Thread.currentThread().getName() + "即将到达集合点1，当前已有:"
								+ (cb.getNumberWaiting() + 1) + "个已经到达," 
								+ (cb.getNumberWaiting() == 2 ? "都到齐了，继续走啊":"正在等待"));
						cb.await();
						
						Thread.sleep((long)(Math.random() * 10000));
						System.out.println("线程:" + Thread.currentThread().getName() + "即将到达集合点2,当前已有:"
								+ (cb.getNumberWaiting() + 1) + "个已经到达,"
								+ (cb.getNumberWaiting() == 2 ? "都到齐了，继续走啊":"正在等待"));
						cb.await();
						
						Thread.sleep((long)(Math.random() * 10000));
						System.out.println("线程" + Thread.currentThread().getName() + "即将到达集合点3，当前已有:"
								+ (cb.getNumberWaiting() + 1) + "个已经到达,"
								+ (cb.getNumberWaiting() == 2 ? "都到齐了，继续走啊":"正在等待"));
						cb.await();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			service.execute(run);
		}
		service.shutdown();
	}
}
