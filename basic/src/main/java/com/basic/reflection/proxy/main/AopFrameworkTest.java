package com.basic.reflection.proxy.main;

import java.io.InputStream;
import java.util.Collection;

import com.basic.reflection.proxy.handler.BeanFactory;

public class AopFrameworkTest {
	public static void main(String[] args) {
		InputStream ips = AopFrameworkTest.class.getResourceAsStream("config.properties");
		Object bean = new BeanFactory(ips).getBean("xxx");
		System.out.println(bean.getClass().getName());
		((Collection)bean).clear();
	}

}
