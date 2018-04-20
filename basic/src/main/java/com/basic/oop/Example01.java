package com.basic.oop;

import java.util.Enumeration;
import java.util.Properties;

public class Example01 {
	
	public static void main(String[] args) {
		// 获取当前系统属性
		Properties properties = System.getProperties();
		// 获得所有系统属性的key，返回Enumeration对象
		Enumeration propertyNames = properties.propertyNames();
		while(propertyNames.hasMoreElements()) {
			// 获取系统属性的键key
			String key = (String)propertyNames.nextElement();
			// 获取当前键key对象的值value
			String value = System.getProperty(key);
			System.out.println(key + "------" + value);
		}
		
	}

}
