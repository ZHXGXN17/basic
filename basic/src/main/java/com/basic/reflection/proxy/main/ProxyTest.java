package com.basic.reflection.proxy.main;

import java.lang.reflect.Proxy;

import com.basic.reflection.proxy.dao.StudentDao;
import com.basic.reflection.proxy.dao.StudentDaoImpl;
import com.basic.reflection.proxy.dao.UserDao;
import com.basic.reflection.proxy.dao.UserDaoImpl;
import com.basic.reflection.proxy.handler.MyInvocationHandler;

public class ProxyTest {
	
	public static void main(String[] args) {
		UserDao userDao = new UserDaoImpl();
		userDao.add();
		userDao.delete();
		userDao.update();
		userDao.find();
		System.out.println("----------------");
		
		/**
		 * 我们要创建一个动态代理对象
		 * Proxy类中有一个方法可以创建动态代理对象
		 */
		MyInvocationHandler handler = new MyInvocationHandler(userDao);
		UserDao proxy = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), 
				userDao.getClass().getInterfaces(), handler);
		proxy.add();
		proxy.delete();
		proxy.update();
        proxy.find();
        System.out.println("-----------");
        
        StudentDao studentDao = new StudentDaoImpl();
        MyInvocationHandler handler2 = new MyInvocationHandler(studentDao);
        StudentDao proxy2 = (StudentDao) Proxy.newProxyInstance(studentDao.getClass().getClassLoader(), 
        		studentDao.getClass().getInterfaces(), handler2);
        proxy2.login();
        proxy2.regist();
        
	}

}
