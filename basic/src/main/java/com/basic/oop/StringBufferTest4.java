package com.basic.oop;

import java.util.Scanner;

public class StringBufferTest4 {
	
	public static void main(String[] args) {
		// 创建键盘录入对象
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个字符串:");
		String s = sc.nextLine();
		
		// 一个一个的比较
		boolean b = isSame(s);
		System.out.println("比较:" + b);
	}
	
	
	public static boolean isSame(String s) {
		boolean flag = true;
		char[] chs = s.toCharArray();
		
		for(int start = 0, end = chs.length - 1; start <= end; start++, end--) {
			if(chs[start] != chs[end]) {
				flag = false;
				break;
			}
		}
		
		return flag;
	}

}
