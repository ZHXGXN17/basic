package com.basic.oop;

/*
 * String的转换功能：
 * byte[] getBytes():把字符串转换为字节数组。
 * char[] toCharArray():把字符串转换为字符数组。
 * static String valueOf(char[] chs):把字符数组转成字符串。
 * static String valueOf(int i):把int类型的数据转成字符串。
 *      注意：String类的valueOf方法可以把任意类型的数据转成字符串。
 * String toLowerCase():把字符串转成小写。
 * String toUpperCase():把字符串转成大写。
 * String concat(String str):把字符串拼接。
 */  
public class StringDemo01 {
	public static void main(String[] args) {
		String str = "JavaSE";
		
		byte[] bys = str.getBytes();
		for(int i = 0;i < bys.length;i++) {
			System.out.println(bys[i]);
		}
		System.out.println("-------------------");
		
		char[] chs = str.toCharArray();
		for(int i = 0;i < chs.length;i++) {
			System.out.println(chs[i]);
		}
		System.out.println("-------------------");
		
		String ss = String.valueOf(str);
		System.out.println(ss);
		System.out.println("--------------------");
		
		System.out.println("toLowerCase:" + str.toLowerCase());
		System.out.println("toUpperCase:" + str.toUpperCase());
		System.out.println("--------------------");
		
		String s1 = "hello";
		String s2 = "world";
		System.out.println("s1+s2:" + s1 + s2);
		
	}

}






























