package com.basic.gson.first.entity;

import java.util.List;

import com.google.gson.annotations.Expose;

/**
 * 基于@Expose注解，简单说来就是需要导出的字段上加上@Expose 注解，不导出的字段不加。注意是不导出的不加
 * 
 * @Expose //
 * @Expose(deserialize = true,serialize = true) //序列化和反序列化都都生效，等价于上一条
 * @Expose(deserialize = true,serialize = false) //反序列化时生效
 * @Expose(deserialize = false,serialize = true) //序列化时生效
 * @Expose(deserialize = false,serialize = false) // 和不写注解一样
 * 
 * @author robin
 *
 */
public class Category {
	
	@Expose public int id;
	
	@Expose public String name;
	
	@Expose public List<Category> children;
	
	// 因业务需要增加，但并不需要序列化
	public Category parent;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int id, String name, List<Category> children) {
		super();
		this.id = id;
		this.name = name;
		this.children = children;
	}
	
	public Category(int id, String name, List<Category> children, Category parent) {
		super();
		this.id = id;
		this.name = name;
		this.children = children;
		this.parent = parent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Category> getChildren() {
		return children;
	}

	public void setChildren(List<Category> children) {
		this.children = children;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", children=" + children + ", parent=" + parent + "]";
	}
	
}
