package com.basic.reflection.proxy.main;

import java.lang.reflect.Proxy;

import com.basic.reflection.proxy.dao.Operate;
import com.basic.reflection.proxy.dao.OperateImpl;
import com.basic.reflection.proxy.handler.TimingInvocationHandler;

public class TimingTest {
	public static void main(String[] args) {
		// create proxy instance
		TimingInvocationHandler timingInvocationHandler = new TimingInvocationHandler(new OperateImpl());
		Operate operate = (Operate)Proxy.newProxyInstance(Operate.class.getClassLoader(), 
				new Class[] {Operate.class}, timingInvocationHandler);
		
		// call method of proxy instance
		operate.operateMethod1();
		System.out.println("-----------------");
		operate.operateMethod2();
		System.out.println("-----------------");
		operate.operateMethod3();
		System.out.println("------------------");
	}

}
