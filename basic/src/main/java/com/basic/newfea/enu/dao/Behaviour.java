package com.basic.newfea.enu.dao;

/**
 * 用法五：实现接口
 * __所有的枚举都继承自java.lang.Enum类。由于Java 不支持多继承，所以枚举对象不能再继承其他类
 * @author robin
 *
 */
public interface Behaviour {
	
	void print();
	
	String getInfo();
}
