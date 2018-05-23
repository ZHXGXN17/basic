package com.basic.coll.colls;

import java.util.Arrays;
import java.util.List;

public class ArrayTest {
	
	public static void main(String[] args) {
		System.out.println("1、将数组转成集合");
        System.out.println("-------------------");
        // asList()将数组转换为集合
        List<Integer> list = Arrays.asList(87, 67, 65, 544);
        System.out.println("list:" + list);
        
        System.out.println("2、二分查找");
        System.out.println("-------------------");
        
        // binarySearch()二分查找
        int[] a = {23, 45, 67, 8, 32, 45, 6, 7, 85, 54, 3, 432};
        int index = Arrays.binarySearch(a, 45);
        System.out.println("index:" + index);
        
        System.out.println("3、排序");
        System.out.println("-------------------");
        
        System.out.println("排序前:" + Arrays.toString(a));
        Arrays.sort(a);
        System.out.println("排序后:" + Arrays.toString(a));
	}

}
