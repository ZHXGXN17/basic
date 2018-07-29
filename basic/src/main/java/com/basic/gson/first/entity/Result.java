package com.basic.gson.first.entity;

/**
 * 采用泛型的返回result实体类
 * @author robin
 *
 * @param <T>
 */
public class Result<T> {
	public int code;
	
    public String message;
    
    public T data;
}
