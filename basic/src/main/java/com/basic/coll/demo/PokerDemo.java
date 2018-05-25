package com.basic.coll.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * 思路：
 * __A:创建一个HashMap集合
 * __B:创建一个ArrayList集合
 * __C:创建花色数组和点数数组
 * __D:从0开始往HashMap里面存储编号，并存储对应的牌
 *     同时往ArrayList里面存储编号即可
 * __E:洗牌(洗编号)
 * __F:发牌(发的编号，为了保证编号是排序的，就创建TreeSet集合接收)
 * __G:看牌(遍历TreeSet集合，获取编号，到HashMap集合找对应的牌)
 * @author robin
 *
 */
public class PokerDemo {
	
	public static void main(String[] args) {
		// 创建一个HashMap集合
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		// 创建一个ArrayList集合
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		// 创建花色数组和点数数组
		// 定义一个花色数组
		String[] colors = {"♠", "♥", "♣", "♦"};
		
		// 定义一个点数数组
		String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q",
	            "K", "A", "2", "1"};
		
		// 从0开始往HashMap里面存储编号，并存储对应的牌，同时往ArrayList里面存储编号即可
		int index = 0;
		
		for(String number : numbers) {
			for(String color : colors) {
				String poker = color.concat(number);
				map.put(index, poker);
				list.add(index);
				index++;
			}
		}
		
		map.put(index, "小王");
		list.add(index);
		index++;
		map.put(index, "大王");
		
		// 洗牌(洗编号)
		Collections.shuffle(list);
		
		// 发牌(发的是编号，为了保证编号是排序的，就创建TreeSet集合接收)
		TreeSet<Integer> fengQingYang = new TreeSet<Integer>();
		TreeSet<Integer> linQingXia = new TreeSet<Integer>();
		TreeSet<Integer> liuYi = new TreeSet<Integer>();
		TreeSet<Integer> diPai = new TreeSet<Integer>();
		
		// 遍历发牌
		for(int i = 0;i < list.size();i++) {
			if(i >= list.size() - 3) {
				diPai.add(list.get(i));
			}else if(i % 3 == 0) {
				fengQingYang.add(list.get(i));
			}else if(i % 3 == 1) {
				linQingXia.add(list.get(i));
			}else if(i % 3 == 2) {
				liuYi.add(list.get(i));
			}
		}
		
		// 看牌(遍历TreeSet集合,获取编号，到HashMap集合找对应的牌)
		lookPoker("风清扬", fengQingYang, map);
		lookPoker("林青霞", linQingXia, map);
		lookPoker("刘意", liuYi, map);
		lookPoker("底牌", diPai, map);
	}
	
	// 看牌的方法
	public static void lookPoker(String name, TreeSet<Integer> set,
			HashMap<Integer, String> map) {
		System.out.print(name + "的牌是:");
		for(Integer key : set) {
			String value = map.get(key);
			System.out.print(value + "");
		}
		System.out.println();
	}

}
