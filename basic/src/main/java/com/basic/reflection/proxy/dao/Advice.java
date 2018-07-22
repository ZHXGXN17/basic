package com.basic.reflection.proxy.dao;

import java.lang.reflect.Method;

public interface Advice {
	
	void beforeMethod(Method method);
	
	void afterMethod(Method method);
}
