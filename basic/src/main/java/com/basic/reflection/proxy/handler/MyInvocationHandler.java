package com.basic.reflection.proxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler{
	
	// 目标对象
	private Object target;
	
	public MyInvocationHandler(Object target) {
		this.target = target;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("权限校验");
		Object result = method.invoke(target, args);
		System.out.println("日志记录");
		return result;
	}

}
