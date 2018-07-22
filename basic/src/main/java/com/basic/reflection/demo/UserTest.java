package com.basic.reflection.demo;

import com.basic.reflection.entity.User;
import com.basic.reflection.service.AnnotationProcessor;

public class UserTest {
	
	public static void main(String[] args) {
		User user = new User();
        AnnotationProcessor.init(user);
        System.out.println(user.toString());
	}

}
