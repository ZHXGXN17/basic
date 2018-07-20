package com.basic.reflection.demo;

import com.basic.reflection.service.MyTag2;

public class AnnotationDemo02 {
	
	public static void m1() {
		
	}
	
	@MyTag2
	public static void m2() {
		
	}
	
	@MyTag2(name = "红薯")
	public static void m3() {
		
	}
	
	@MyTag2(name = "红薯", age = 30)
	public static void m4() {
		
	}
}
