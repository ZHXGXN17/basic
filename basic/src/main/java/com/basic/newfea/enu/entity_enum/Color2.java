package com.basic.newfea.enu.entity_enum;

/**
 * 用法三：向枚举中添加新方法
 *   如果打算自定义自己的方法，那么必须在enum实例序列的最后添加一个分号。而且 Java 要求必须先定义 enum 实例
 * 
 * @author robin
 *
 */
public enum Color2 {
	
	RED("红色", 1), GRENN("绿色", 2), BLANK("白色", 3), YELLOW("黄色", 4);
	
	// 成员变量
	private String name;
	
	private int index;
	
	// 构造方法
	private Color2(String name, int index) {
		this.name = name;
		this.index = index;
	}
	
	// 普通方法
	public static String getName(int index) {
		for(Color2 color : Color2.values()) {
			if(color.getIndex() == index) {
				return color.name;
			}
		}
		return null;
	}

	// get set 方法
    public String getName() {
        return name;
    }
    
	public void setName(String name) {
        this.name = name;
    }
	
    public int getIndex() {
        return index;
    }
    
    public void setIndex(int index) {
        this.index = index;
    }
}
