package com.basic.thread.synutils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class TwinsLock implements Lock{
	
	private final Sync sync = new Sync(2);
	
	private static final class Sync extends AbstractQueuedSynchronizer{

		private static final long serialVersionUID = -3554074385705026929L;
		
		Sync(int count){
			if(count <= 0) {
				throw new IllegalArgumentException("count must large than zero.");
			}
			
			setState(count);
		}
		
		
		public int tryAcquireShared(int reduceCount) {
			for(;;) {
				int current = getState();
				int newCount = current - reduceCount;
				if(newCount < 0 || compareAndSetState(current, newCount)) {
					return newCount;
				}
			}
		}
		
		
		public boolean tryReleaseShared(int returnCount) {
			for(;;) {
				int current = getState();
				int newCount = current + returnCount;
				if(compareAndSetState(current, newCount)) {
					return true;
				}
			}
		}
	}
	

	public void lock() {
		sync.acquireShared(1);
	}

	public void lockInterruptibly() throws InterruptedException {
		sync.acquireInterruptibly(1);
	}

	public boolean tryLock() {
		return sync.tryAcquireShared(1) >= 0;
	}

	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		return sync.tryAcquireSharedNanos(1, unit.toNanos(time));
	}

	public void unlock() {
		sync.tryReleaseShared(1);
	}

	public Condition newCondition() {
		return null;
	}

}
