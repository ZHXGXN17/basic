package com.basic.reflection.service;

import java.lang.reflect.Method;

public class ProcessTool {
	
	/**
	 * 处理方法1
	 * 
	 * @param clazz
	 */
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
	
	
	/**
	 * 处理方法2
	 * 
	 * @param clazz
	 */
	public static void process2(String clazz) {
		Class targetClass = null;
		
		try {
			targetClass = Class.forName(clazz);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		for(Method method : targetClass.getMethods()) {
			if(method.isAnnotationPresent(MyTag2.class)) {
				MyTag2 tag = method.getAnnotation(MyTag2.class);
				System.out.println("方法: " + method.getName() + "的MyTag2注解内容为: " + tag.name() + "," + tag.age());
			}
		}
	}

}
