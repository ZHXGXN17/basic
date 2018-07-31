package com.basic.gson.fourth;

import java.io.IOException;

import com.basic.gson.first.entity.User;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * TypeAdapter用于接管某种类型的序列化和反序列化过程，
 * 包含两个注要方法 
 *    write(JsonWriter,T) 和 
 *    read(JsonReader) 
 *    其它的方法都是final方法并最终调用这两个抽象方法
 *    
 * @author robin
 *
 */
public class UserTypeAdapter extends TypeAdapter<User>{

	@Override
	public User read(JsonReader in) throws IOException {
		User user = new User();
		in.beginObject();
		while(in.hasNext()) {
			switch(in.nextName()) {
			case "name":
				user.name = in.nextString();
				break;
			case "age":
				user.age = in.nextInt();
				break;
			case "email":
			case "email_address":
			case "emailAddress":
				user.emailAddress = in.nextString();
				break;
			}
		}
		in.endObject();
		return user;
	}

	@Override
	public void write(JsonWriter out, User value) throws IOException {
		out.beginObject();
		out.name("name").value(value.name);
		out.name("age").value(value.age);
		out.name("email").value(value.emailAddress);
		out.endObject();
	}

}
