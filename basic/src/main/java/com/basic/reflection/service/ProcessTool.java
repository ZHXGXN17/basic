package com.basic.reflection.service;

import java.lang.reflect.Method;

public class ProcessTool {
	
	public static void process(String clazz) {
		Class targetClass = null;
		try {
			targetClass = Class.forName(clazz);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		for(Method method : targetClass.getMethods()) {
			if(method.isAnnotationPresent(MyTag.class)) {
				System.out.println("被MyTag注解修饰的方法名: " + method.getName());
			}else {
				System.out.println("没被MyTag注解修饰的方法名: " + method.getName());
			}
		}
	}

}
