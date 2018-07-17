package com.basic.reflection.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * getCanonicalName、getSimpleName、getName的区别
 * 
 * @author robin
 *
 */
public class ReflectDemo2 {
	
	public static void main(String[] args) {
		System.out.println("****************int*******************");
		System.out.println(int.class.getCanonicalName()); // int
		System.out.println(int.class.getSimpleName()); // int
		System.out.println(int.class.getName()); // int
		
		System.out.println("*****************String****************");
		System.out.println(String.class.getCanonicalName());// java.lang.String
		System.out.println(String.class.getSimpleName()); // String
		System.out.println(String.class.getName()); // java.lang.String
		
		System.out.println("***************CharSequence*************");
		CharSequence str = new String();
		System.out.println(str.getClass().getCanonicalName());// java.lang.String
		System.out.println(str.getClass().getSimpleName()); // String
		System.out.println(str.getClass().getName()); // java.lang.String
		
		System.out.println("*******************String[]********************");
		String[] arrStr = new String[] {};
		System.out.println(arrStr.getClass().getCanonicalName());// java.lang.String[]
		System.out.println(arrStr.getClass().getSimpleName()); // String[]
		System.out.println(arrStr.getClass().getName()); // [Ljava.lang.String;
		
		System.out.println("*******************List<String>*****************");
		List<String> list = new ArrayList<String>();
		list.add(new String());
		System.out.println(list.getClass().getCanonicalName()); // java.util.ArrayList
		System.out.println(list.getClass().getSimpleName()); // ArrayList
		System.out.println(list.getClass().getName()); // java.util.ArrayList
	}

}
