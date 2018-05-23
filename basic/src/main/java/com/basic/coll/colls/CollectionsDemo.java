package com.basic.coll.colls;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections:是针对集合进行操作的工具类，都是静态方法
 * 
 * 面试题:
 * Collection和Collections的区别
 * Collection:是单列集合的顶层接口，有子接口List和Set
 * Collections:是针对集合操作的工具类，有对集合进行排序和二分查找的方法
 * 
 * 方法:
 * ___public static <T> void sort(List<T> list):排序默认情况下是自然排序
 * ___public static <T> int binarySearch(List<?> list, T key):二分查找
 * ___public static <T> T max(Collection<?> coll):最大值
 * ___public static void reverse(List<?> list):反转
 * ___public static void shuffle(List<?> list):随机置换
 * @author robin
 *
 */
public class CollectionsDemo {
	
	public static void main(String[] args) {
		// 创建集合对象
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(20);
		list.add(10);
		
		System.out.println("list:" + list);
		
		// 排序
		Collections.sort(list);
		System.out.println("排序:" + list);
		
		// 二分查找
		System.out.println(Collections.binarySearch(list, 30));
		
		// 最大值
		System.out.println(Collections.max(list));
		
		// 反转
		Collections.reverse(list);
		System.out.println("反转:" + list);
		
		// 随机置换
		Collections.shuffle(list);
		System.out.println("随机置换:" + list);
	}

}
