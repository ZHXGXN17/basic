package com.basic.gson.first.entity;

import com.google.gson.annotations.SerializedName;

/**
 * User实体类
 * 
 * @author robin
 *
 */
public class User {
	
	public String name;
	
	public int age;
	
	@SerializedName(value = "emailAddress", alternate = {"email_address", "email"})
	public String emailAddress;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public User(String name, int age, String emailAddress) {
		super();
		this.name = name;
		this.age = age;
		this.emailAddress = emailAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", emailAddress=" + emailAddress + "]";
	}
	
	
}
