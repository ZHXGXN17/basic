package com.basic.gson.second;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;

import com.basic.gson.first.entity.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * 1.Gson的流式反序列化
 * 2.Gson的流式序列化
 * 3.使用GsonBuilder导出null值、格式化输出、日期时间及其他小功能
 * 
 * 常用方法
 *   Gson.toJson(Object);
 *   Gson.fromJson(Reader, Class);
 *   Gson.fromJson(String, Class);
 *   Gson.fromJson(Reader, Type);
 *   Gson.fromJson(String, Type);
 * @author robin
 *
 */
public class GsonDemo02 {
	
	public static void main(String[] args) throws IOException{
		read();
		writer();
		gsonBuilder();
	}
	
	
	/**
	 * 流式反序列化
	 * 
	 * @return
	 * @throws IOException
	 */
	public static String read() throws IOException{
		System.out.println("=======================Gson的流式反序列化===================");
		// {"name":"加勒比海盗3","age":"24","emailAddress":"wangyf_17@163.com"}
		String json = "{\"name\":\"加勒比海盗3\",\"age\":\"24\",\"emailAddress\":\"wangyf_17@163.com\"}";
		User user = new User();
		JsonReader reader = new JsonReader(new StringReader(json));
		reader.beginObject();
		while(reader.hasNext()) {
			String s = reader.nextName();
			switch(s) {
			case "name":
				user.name = reader.nextString();
				break;
			case "age":
				user.age = reader.nextInt();
				break;
			case "emailAddress":
				user.emailAddress = reader.nextString();
				break;
			}
		}
		reader.endObject();
		System.out.println(user.name);
		System.out.println(user.age);
		System.out.println(user.emailAddress);
		
		return user.name + "," + user.age + "," + user.emailAddress;
	}
	
	
	/**
	 * Gson的流式序列化
	 * @throws IOException
	 */
	public static void writer() throws IOException{
		System.out.println("===========Gson流式序列化=================");
		Gson gson = new Gson();
		User user = new User("加勒比海盗4", 24, "wangyf_17@163.com");
		gson.toJson(user, System.out); // 写到控制台
		System.out.println();
		JsonWriter writer = new JsonWriter(new OutputStreamWriter(System.out));
		writer.beginObject()
		         .name("name").value("加勒比海盗4")
		         .name("age").value(24)
		         .name("emailAddress").value("wangyf_17@163.com")
		         .endObject();
		writer.flush();
//		writer.close();
		System.out.println();
	}
	
	
	/**
	 * GsonBuilder导出null
	 * 
	 */
	public static void gsonBuilder() {
		System.out.println("=================GsonBuilder==================");
		Gson gson = new Gson();
		User user = new User("加勒比海盗4", 24);
		System.out.println(gson.toJson(user)); // 没有空值{"name":"加勒比海盗4","age":24}
		
		gson = new GsonBuilder().serializeNulls().create();
		System.out.println(gson.toJson(user)); // {"name":"加勒比海盗4","age":24,"emailAddress":null}
		
		
		// 格式化输出、日期时间及其它
		gson = new GsonBuilder()
				   // 序列化null
				   .serializeNulls()
				   // 设置日期时间格式，另有2个重载方法
				   // 在序列化和反序列化时均生效
				   .setDateFormat("yyyy-MM-dd")
				   // 禁止序列化内部类
				   .disableInnerClassSerialization()
				   // 生成不可执行的Jsonduol)]}'4个字符
				   .generateNonExecutableJson()
				   // 禁止转义heml标签
				   .disableHtmlEscaping()
				   // 格式化输出
				   .setPrettyPrinting()
				   .create();
		System.out.println(gson.toJson(user));
	}

}
