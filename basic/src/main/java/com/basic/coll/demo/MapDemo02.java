package com.basic.coll.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map集合的遍历
 * Map -- 夫妻对
 * 思路:
 * __A:获取所有结婚证的集合
 * __B:遍历结婚证的集合，得到每一个结婚证
 * __C:根据结婚证获取丈夫和妻子
 * 
 * 转换:
 * __A:获取所有键值对对象的集合
 * __B:遍历键值对对象的集合，得到每一个键值对对象
 * __C:根据键值对对象获取键和值
 * 
 * Set<Map.Entry<K,V>> entrySet():返回的是键值对对象的集合
 * @author robin
 *
 */
public class MapDemo02 {

	public static void main(String[] args) {
		// 创建集合对象
        Map<String, String> map = new HashMap<String, String>();

        // 创建元素并添加到集合
        map.put("杨过", "小龙女");
        map.put("郭靖", "黄蓉");
        map.put("杨康", "穆念慈");
        map.put("陈玄风", "梅超风");
        
        System.out.println("map:" + map);
        
        // 获取所有键值对对象的集合
        Set<Map.Entry<String, String>> set = map.entrySet();
        // 遍历键值对对象的集合，得到每一个键值对对象
        for(Map.Entry<String, String> ms : set) {
        	// 根据键值对对象获取键和值
        	String key = ms.getKey();
        	String value = ms.getValue();
        	System.out.println(key + "=" + value);
        }
	}
}
