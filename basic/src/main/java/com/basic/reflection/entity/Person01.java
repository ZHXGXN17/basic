package com.basic.reflection.entity;

/**
 * Person01实体类
 * 
 * @author robin
 *
 */
public class Person01 {
	
	private String name;
	
	int age;
	
	public String address;
	
	public Person01() {
		
	}
	
	public Person01(String name) {
		this.name = name;
	}
	
	public Person01(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Person01(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	public void show() {
		System.out.println("show");
	}
	
	public void method(String s) {
		System.out.println("method:" + s);
	}
	
	public String getString(String s, int i) {
		return s + "----" + i;
	}
	
	private void function() {
		System.out.println("function");
	}

	@Override
	public String toString() {
		return "Person01 [name=" + name + ", age=" + age + ", address=" + address + "]";
	}
	
}
