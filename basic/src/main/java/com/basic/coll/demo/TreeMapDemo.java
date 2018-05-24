package com.basic.coll.demo;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * 需求:"aababcabcdabcde",获取字符串中每一个字母出现的次数，要求结果:a(5)b(4)c(3)d(2)e(1)
 * 
 * 分析:
 * __A:定义一个字符串(可以改进为键盘录入)
 * __B:定义一个TreeMap集合
 *     键:Character
 *     值:Integer
 * __C:把字符串转换为字符数组
 * __D:遍历字符数组，得到每一个字符
 * __E:拿刚才得到的字符作为键到集合中去找值，看返回值
 *     是null：说明该键不存在，就把该字符作为键，1作为值存储
 *     不是null：说明该键存在，就把值加1，然后重写存储该键和值
 * __F:定义字符串缓冲区变量
 * __G:遍历集合，得到键和值，进行按照要求拼接
 * __H:把字符串缓冲区转换为字符串输出    
 * @author robin
 *
 */
public class TreeMapDemo {

	public static void main(String[] args) {
		// 定义一个字符串(可以为控制台录入)
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个字符串");
		String str = sc.nextLine();
		
		// 定义一个TreeMap集合
	    TreeMap<Character, Integer> tm = new TreeMap<Character, Integer>();
	    // 把字符串转化为字符数组
	    char[] chs = str.toCharArray();
	    // 遍历数组，得到每一个字符
	    for(char c : chs) {
	    	// 拿刚才得到的字符作为键到集合中去找值，看返回值
	    	Integer i = tm.get(c);
	    	// 是null:说明该键不存在，就把该字符作为键，1作为值存储
	    	if(i == null) {
	    		tm.put(c, 1);
	    	}else {
	    		i++;
	    		tm.put(c, i);
	    	}
	    }
	    
	    // 遍历结果按照要求格式输出,定义字符串缓冲区变量
	    StringBuilder sb = new StringBuilder();
	    // 遍历集合，得到键和值，进行按照要求拼接
	    Set<Character> set = tm.keySet();
	    for(Character key : set) {
	    	Integer value = tm.get(key);
	    	sb.append(key).append("(").append(value).append(")");
	    }
	    
	    System.out.println("result:" + sb.toString());
	}
}
