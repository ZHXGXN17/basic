package com.basic.reflection.proxy.handler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.basic.reflection.proxy.dao.Advice;

public class BeanFactory {
	
	Properties mProperties = new Properties();
	
	public BeanFactory(InputStream input) {
		try {
			mProperties.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Object getBean(String name) {
		String className = mProperties.getProperty(name);
		Object bean = null;
		Class clazz;
		try {
			clazz = Class.forName(className);
			bean = clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(bean instanceof ProxyFactoryBean) {
			Object proxy = null;
			ProxyFactoryBean factoryBean = (ProxyFactoryBean) bean;
			Advice advice = null;
			try {
				advice = (Advice) Class.forName(mProperties.getProperty(name + ".advice")).newInstance();
				Object target = Class.forName(mProperties.getProperty(name + ".target")).newInstance();
				factoryBean.setAdvice(advice);
				factoryBean.setTarget(target);
				proxy = factoryBean.getProxy();
			} catch (Exception e) {
				e.printStackTrace();
			} 
			return proxy;
		}
		
		return bean;
	}

}
