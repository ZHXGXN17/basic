package com.basic.gson.first.entity;

import java.util.List;

/**
 * List<User>
 * @author robin
 *
 */
public class UserListResult {
	
	public int code;
	
	public String message;
	
	public List<User> data;

	public UserListResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserListResult(int code, String message, List<User> data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<User> getData() {
		return data;
	}

	public void setData(List<User> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "UserListResult [code=" + code + ", message=" + message + ", data=" + data + "]";
	}
	
	
}
