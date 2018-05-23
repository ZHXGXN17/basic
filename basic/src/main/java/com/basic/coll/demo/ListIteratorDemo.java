package com.basic.coll.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * 问题：有一个集合，想判断集合里面有没有“world”这个元素，如果有，就添加一个”javaee“元素，写代码实现
 * 
 * 
 * @author robin
 *
 */
public class ListIteratorDemo {
	
	public static void main(String[] args) {
		// 创建List集合对象
		List list = new ArrayList();
		
		// 添加元素
		list.add("hello");
		list.add("world");
		list.add("java");
		
		/**
		 * 迭代器遍历
		 * ConcurrentModificationException:当方法检测到对象的并发修改，但不允许这种修改时，抛出此异常。
		 * 产生原因:
		 * ___迭代器是依赖于集合而存在的，在判断成功后，集合的中新添加了元素，而迭代器却不知道，所以就报错了，这个错叫并发修改异常。
		 * ___其实这个问题描述的是：迭代器遍历元素的时候，通过集合是不能修改元素的。
		 */
//		Iterator itr = list.iterator();
//		while(itr.hasNext()) {
//			String s = (String)itr.next();
//			if("world".equals(s)) {
//				list.add("javaee");
//			}
//		}
		
		/**
		 * 方式2：迭代器迭代元素，迭代器修改元素
		 *     而Iterator迭代器却没有添加功能，所以我们使用其子接口ListIterator
		 * 错误：java.util.ConcurrentModificationException
		 */
//		ListIterator lit = list.listIterator();
//		while(lit.hasNext()) {
//			String s = (String)lit.next();
//			if("world".equals(s)) {
//				list.add("javase");
//			}
//		}
		
		/**
		 * 方式2：集合遍历元素，集合修改元素(普通for)
		 */
		for(int i = 0;i < list.size();i++) {
			String s = (String)list.get(i);
			if("world".equals(s)) {
				list.add("javase");
			}
		}
		
		System.out.println("list:" + list);

	}

}





















