package com.basic.reflection.service;

import java.lang.reflect.Constructor;

import com.basic.reflection.entity.User;

/**
 * UserMeta注解处理类
 * 
 * @author robin
 *
 */
public class AnnotationProcessor {
	
	public static void init(Object object) {
		if(!(object instanceof User)) {
			throw new IllegalArgumentException("[" + object.getClass().getSimpleName() + "] isn't type of User");
		}
		
		Constructor[] constructors = object.getClass().getDeclaredConstructors();
		// 遍历
		for(Constructor constructor : constructors) {
			if(constructor.isAnnotationPresent(UserMeta.class)) {
				UserMeta userFill = (UserMeta)constructor.getAnnotation(UserMeta.class);
				int age = userFill.age();
				int id = userFill.id();
				String name = userFill.name();
				((User) object).setAge(age);
				((User) object).setId(id);
				((User) object).setName(name);
			}
		}
	}

}
