package com.basic.gson.fourth;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.basic.gson.first.entity.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * GsonDemo04
 * __TypeAdapter
 * __JsonSerializer与JsonDeserializer
 * __@JsonAdapter注解
 * __TypeAdapter与 JsonSerializer、JsonDeserializer对比
 * __TypeAdapter实例
 * 
 * @author robin
 *
 */
public class GsonDemo04 {
	
	public static void main(String[] args) {
//		adapterTest();
//		intTest();
//		serDeserTest();
//		jsonDeser();
		vsTest();
	}

	
	/**
	 * TypeAdapter的基本使用
	 */
	public static void adapterTest() {
		User user = new User("加勒比海盗3", 24);
		user.emailAddress = "wangyf_17@163.com";
		Gson gson = new GsonBuilder()
				// 为User注册TypeAdapter
				.registerTypeAdapter(User.class, new UserTypeAdapter())
				.create();
		System.out.println(gson.toJson(user));
	}
	
	
	/**
	 * 空值的转化
	 */
	public static void intTest() {
		Gson gson = new GsonBuilder()
				.registerTypeAdapter(Integer.class, new TypeAdapter<Integer>() {
					@Override
					public Integer read(JsonReader in) throws IOException {
					    try {
					    	return Integer.parseInt(in.nextString());
					    }catch(NumberFormatException e) {
					    	return -1;
					    }
					}

					@Override
					public void write(JsonWriter out, Integer value) throws IOException {
						out.value(String.valueOf(value));
					}
				})
				.create();
		System.out.println(gson.toJson(100)); // "100"
		System.out.println(gson.fromJson("\"\"", Integer.class)); // -1
	}
	
	
	/**
	 * JsonSerializer与JsonDeserializer
	 * JsonSerializer 和JsonDeserializer
	 * 不用像TypeAdapter一样，必须要实现序列化和反序列化的过程，
	 * 你可以据需要选择，如只接管序列化的过程就用 JsonSerializer ，
	 * 只接管反序列化的过程就用 JsonDeserializer ，如上面的需求可以用下面的代码
	 * 
	 */
	public static void serDeserTest() {
		Gson gson = new GsonBuilder()
				.registerTypeAdapter(Integer.class, new JsonDeserializer<Integer>() {
					@Override
					public Integer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
							throws JsonParseException {
						try {
							return json.getAsInt();
						}catch(NumberFormatException e) {
							return -1;
						}
					}
				})
				.create();
		System.out.println(gson.toJson(100)); // 100
		System.out.println(gson.fromJson("\"\"", Integer.class)); // 
	}
	
	
	/**
	 * 所有数字都转成序列化为字符串的例子
	 */
	public static void jsonDeser() {
		JsonSerializer<Number> numberJsonSerializer = new JsonSerializer<Number>() {
			@Override
			public JsonElement serialize(Number src, Type typeOfSrc, JsonSerializationContext context) {
				return new JsonPrimitive(String.valueOf(src));
			}
		};
		
		Gson gson = new GsonBuilder()
				.registerTypeAdapter(Integer.class, numberJsonSerializer)
				.registerTypeAdapter(Long.class, numberJsonSerializer)
				.registerTypeAdapter(Float.class, numberJsonSerializer)
				.registerTypeAdapter(Double.class, numberJsonSerializer)
				.create();
		System.out.println(gson.toJson(100.0f)); // "100.0"
	}
	
	
	public static void vsTest() {
		Type type = new TypeToken<List<User>>() {}.getType();
		TypeAdapter typeAdapter = new TypeAdapter<List<User>>() {
			@Override
			public List<User> read(JsonReader arg0) throws IOException {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public void write(JsonWriter arg0, List<User> arg1) throws IOException {
				// TODO Auto-generated method stub
			}
		};
		Gson gson = new GsonBuilder()
				.registerTypeAdapter(type, typeAdapter)
				.create();
		List<User> list = new ArrayList<>();
		list.add(new User("a", 11));
		list.add(new User("b", 22));
		String result = gson.toJson(list, type);
		System.out.println(result);
	}
}
