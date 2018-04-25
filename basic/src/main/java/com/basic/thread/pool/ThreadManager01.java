package com.basic.thread.pool;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadManager01 {
	
	public static final String DEFAULT_SINGLE_POOL_NAME = "DEFAULT_SINGLE_POOL_NAME";
	
	private static ThreadPoolProxy mLongPool = null;
	private static Object mLongLock = new Object();
	
	private static ThreadPoolProxy mShortPool = null;
	private static Object mShortLock = new Object();
	
	private static ThreadPoolProxy mDownloadPool = null;
	private static Object mDownloadLock = new Object();
	
	private static Map<String, ThreadPoolProxy> mMap = new HashMap<String, ThreadPoolProxy>();
	private static Object mSingleLock = new Object();
	
	
	public static ThreadPoolProxy getDownloadPool() {
		synchronized(mDownloadLock) {
			if(mDownloadPool == null) {
				mDownloadPool = new ThreadPoolProxy(3, 3, 5L);
			}
			
			return mDownloadPool;
		}
	}
	
	
	
	

}

