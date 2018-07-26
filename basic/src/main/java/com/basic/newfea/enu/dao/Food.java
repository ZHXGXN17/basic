package com.basic.newfea.enu.dao;

/**
 * 用法六：使用接口组织枚举
 * 
 * @author robin
 *
 */
public interface Food {
	
	enum Coffee implements Food{
		BLACK_COFFEE, DECAF_COFFEE, LATTE, CAPPUCCINO
	}
	
	enum Dessert implements Food{
		FRUIT, CAKE, GELATO
	}
}
