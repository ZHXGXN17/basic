package com.basic.oop;

public class ArrayTool {
	
	private ArrayTool() {};
	
	// 获取整型数组的最大值
	public static int getMax(int[] arr) {
		int maxIndex = 0;
		for(int i = 1;i < arr.length;i++) {
			if(arr[i] > arr[maxIndex]) {
				maxIndex = i;
			}
		}
		return arr[maxIndex];
	}
	
	// 对数组进行选择排序
	public static void selectSort(int[] arr) {
		for(int i = 0;i < arr.length - 1;i++) {
			for(int j = i + 1;j < arr.length;j++) {
				if(arr[i] > arr[j]) {
					swap(arr, i ,j);
				}
			}
		}
	}
	
	// 用于给数组进行元素的位置置换
	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	// 获取指定的元素在指定数组中的索引
	public static int getIndex(int[] arr, int key) {
		for(int i = 0;i < arr.length;i++){
			if(arr[i] == key) {
				return i;
			}
		}
		return -1;
	}
	
	// 将int 数组转换成字符串，格式是：[e1,e2,...]
	public static String arrayToString(int[] arr) {
		String str = "[";
		
		for(int i = 0;i < arr.length;i++) {
			if(i != arr.length -1) {
				str = str + arr[i] + ",";
			}else {
				str = str + arr[i] + "]";
			}
		}
		return str;
	}

}
