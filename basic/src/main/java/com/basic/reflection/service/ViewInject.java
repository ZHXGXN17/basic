package com.basic.reflection.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewInject{
	int value(); // 当时用注解时，如果只给名为value的属性赋值时，可以省略"value="
	
	String name() default "zhangsan"; //默认值 
}