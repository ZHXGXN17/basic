package com.basic.oop.exception;

public class Demo01 {

	public static void main(String[] args) {
		int[] arr = new int[3];
		Demo.method(arr, 30);
	}
	
}

class Demo{
	public static int method(int[] arr, int index) {
		if(arr == null) {
			throw new NullPointerException("数组的引用不能为空!");
		}
		if(index >= arr.length) {
			throw new ArrayIndexOutOfBoundsException("数组角标越界:" + index);
		}
		
		return arr[index];
	}
}

