package com.basic.newfea.enu.entity_enum;

/**
 * 用法四：覆盖枚举的方法
 *   覆盖toString方法
 * @author robin
 *
 */
public enum Color3 {
	
	RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLOW("黄色", 4);
	
	// 成员变量
	private String name;
	
	private int index;
	
	// 构造方法
	private Color3(String name, int index) {
		this.name = name;
		this.index = index;
	}
	
	public String toString() {
		return this.index + "_" + this.name();
	}
	
}
