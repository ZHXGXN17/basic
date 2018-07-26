package com.basic.newfea.enu.entity_enum;

import com.basic.newfea.enu.dao.Behaviour;

/**
 * 用法五：实现接口
 * __所有的枚举都继承自java.lang.Enum类。由于Java 不支持多继承，所以枚举对象不能再继承其他类
 * @author robin
 *
 */
public enum Color4 implements Behaviour{
	RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLOW("黄色", 4);
	
	// 成员变量
    private String name;
    
    private int index;
    
    // 构造方法
    private Color4(String name, int index) {
        this.name = name;
        this.index = index;
    }

	public void print() {
		System.out.println(this.index+":"+this.name);
	}

	public String getInfo() {
		return this.name;
	}
	
}