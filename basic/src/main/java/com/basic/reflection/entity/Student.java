package com.basic.reflection.entity;

import java.io.Serializable;

public class Student extends Person implements Serializable{
	
	int mGrade;

	public Student(String aName) {
		super(aName);
		// TODO Auto-generated constructor stub
	}
	
	public Student(int grade, String aName) {
		super(aName);
		mGrade = grade;
	}
	
	private void learn(String course) {
		System.out.println(mName + "learn" + course);
	}

	public void takeAnExamination() {
		System.out.println(" takeAnExamination ");
	}
	
	public String toString() {
		return " Student " + mName;
	}

}
