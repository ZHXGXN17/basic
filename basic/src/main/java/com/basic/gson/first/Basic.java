package com.basic.gson.first;

import com.basic.gson.first.entity.User;
import com.google.gson.Gson;

/**
 * Gson的基本用法
 * 
 * 属性重命名 @SerializedName 注解的使用
 * 
 * @author robin
 *
 */
public class Basic {
	
	public static void main(String[] args) {
		Gson gson = new Gson();
		// 基本数据类型的解析
		int i = gson.fromJson("100", int.class); // 100
		double d = gson.fromJson("\"99.99\"", double.class); // 99.99
		boolean b = gson.fromJson("true", boolean.class); // true
		String str = gson.fromJson("String", String.class); // String
		System.out.println(i + "---" + d + "---" + b + "---" + str);
		
		System.out.println("================================================");
		
		// 基本数据类型的生成
		String jsonNumber = gson.toJson(100); // 100
		String jsonBoolean = gson.toJson(false); // false
		String jsonString = gson.toJson("String"); // String
		System.out.println(jsonNumber + "---" + jsonBoolean + "---" + jsonString);
		
		System.out.println("===================================================");
		
		// POJO类生成json
		User user = new User("加勒比海盗3", 24, "wangyf_17@163.com");
		String jsonObject = gson.toJson(user);
		System.out.println(jsonObject); // {"name":"加勒比海盗3","age":24,"emailAddress":"wangyf_17@163.com"}
		
		System.out.println("===============================================");
		
		// POJO类解析json
		jsonString = "{\"name\":\"加勒比海盗3\",\"age\":24,\"email_address\":\"wangyf_17@163.com\"}";
		user = gson.fromJson(jsonString, User.class);
        System.out.println(user);
	}

}
