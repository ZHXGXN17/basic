package com.basic.coll.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map集合的遍历:
 * Map -- 夫妻对
 * 思路：
 * __A:把所有的丈夫集中起来
 * __B:遍历丈夫的集合，获取得到每一个丈夫
 * __C:让丈夫去找自己的妻子
 * 
 * 转换:
 * __A:获取所有的键
 * __B:编辑键的集合，获取得到每一个键
 * __C:根据键去找值
 * @author robin
 *
 */
public class MapDemp {
	
	public static void main(String[] args) {
		// 创建集合对象
		Map<String, String> map = new HashMap<String, String>();
		
		// 添加集合
		map.put("杨过", "小龙女");
		map.put("周星驰", "朱茵");
		map.put("乔峰", "阿朱");
		map.put("郭靖", "黄蓉");
		
		// 遍历准备
		Set<String> set = map.keySet();
		for(String str : set) {
			System.out.println(str + ":" + map.get(str));
		}
	}

}
