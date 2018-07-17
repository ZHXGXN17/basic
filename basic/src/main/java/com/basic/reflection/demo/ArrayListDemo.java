package com.basic.reflection.demo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 需求：给ArrayList<Integer>的一个对象，在这个集合中添加一个字符串数据
 * 
 * @author robin
 *
 */
public class ArrayListDemo {
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		Class c = array.getClass();
		Method m = c.getMethod("add", Object.class);
		
		m.invoke(array, "hello");
		m.invoke(array, "java");
		
		System.out.println(array);
	}

}
