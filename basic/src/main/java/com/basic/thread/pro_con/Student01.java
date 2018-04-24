package com.basic.thread.pro_con;

import java.io.Serializable;

public class Student01 implements Serializable{
	
	String name;
	
	int age;
	
	boolean flag;

	public Student01() {
		super();
	}

	public Student01(String name, Integer age, Boolean flag) {
		super();
		this.name = name;
		this.age = age;
		this.flag = flag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Student01 [name=" + name + ", age=" + age + ", flag=" + flag + "]";
	}
	
	
}
