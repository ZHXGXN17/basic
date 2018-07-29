package com.basic.gson.first;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.basic.gson.first.entity.Result;
import com.basic.gson.first.entity.User;
import com.basic.gson.first.entity.UserListResult;
import com.basic.gson.first.entity.UserResult;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Gson中使用泛型
 * 
 * @author robin
 *
 */
public class Generic {
	
	public static void main(String[] args) {
		Gson gson = new Gson();
		String jsonArray = "[\"Android\",\"Java\",\"PHP\"]";
		String[] strings = gson.fromJson(jsonArray, String[].class);
		System.out.println(Arrays.toString(strings));
		
		/**
		 * TypeToken的构造方法是protected修饰的,所以上面才会写成
		 *    new TypeToken<List<String>>() {}.getType() 
		 *    而不是  new TypeToken<List<String>>().getType()
		 */
		List<String> stringList = gson.fromJson(jsonArray, new TypeToken<List<String>>() {}.getType());
		System.out.println(stringList);
		
		System.out.println("===============================================");
		
		UserListResult result = new UserListResult();
		result.setCode(0);
		result.setMessage("success");
		List<User> list =new ArrayList<User>();
		User user = new User("加勒比海盗3", 24, "wangyf_17@163.com");
		list.add(user);
		user = new User("加勒比海盗4", 24, "wangyf_17@163.com");
		list.add(user);
		result.setData(list);
		String jsonResult = gson.toJson(result, UserListResult.class);
		System.out.println(jsonResult);
		
		// user
		// {"code":"0","message":"success","data":[{"name":"加勒比海盗3","age":24,"emailAddress":"wangyf_17@163.com"}}
		String json = "{\"code\":\"0\",\"message\":\"success\",\"data\":{\"name\":\"加勒比海盗3\",\"age\":24,\"emailAddress\":\"wangyf_17@163.com\"}}";
		UserResult userResult = gson.fromJson(json, UserResult.class);
		User user1 = userResult.data;
		System.out.println(user1);
		
		// List<User>
		// {"code":0,"message":"success","data":[{"name":"加勒比海盗3","age":24,"emailAddress":"wangyf_17@163.com"},{"name":"加勒比海盗4","age":24,"emailAddress":"wangyf_17@163.com"}]}
		json = "{\"code\":0,\"message\":\"success\",\"data\":[{\"name\":\"加勒比海盗3\",\"age\":24,\"emailAddress\":\"wangyf_17@163.com\"},{\"name\":\"加勒比海盗4\",\"age\":24,\"emailAddress\":\"wangyf_17@163.com\"}]}";
		UserListResult userListResult = gson.fromJson(json, UserListResult.class);
		List<User> users = userListResult.data;
		System.out.println(users);
		
		System.out.println("=======================================================");
		// 采用泛型
		//不再重复定义Result类
		json = "{\"code\":\"0\",\"message\":\"success\",\"data\":{\"name\":\"加勒比海盗3\",\"age\":24,\"emailAddress\":\"wangyf_17@163.com\"}}";
		Type userType = new TypeToken<Result<User>>(){}.getType();
		Result<User> userResult2 = gson.fromJson(json,userType);
		User user2 = userResult.data;
		System.out.println(user2);

		json = "{\"code\":0,\"message\":\"success\",\"data\":[{\"name\":\"加勒比海盗3\",\"age\":24,\"emailAddress\":\"wangyf_17@163.com\"},{\"name\":\"加勒比海盗4\",\"age\":24,\"emailAddress\":\"wangyf_17@163.com\"}]}";
		Type userListType = new TypeToken<Result<List<User>>>(){}.getType();
		Result<List<User>> userListResult2 = gson.fromJson(json,userListType);
		List<User> users2 = userListResult.data;
		System.out.println(users2);
	}

}
