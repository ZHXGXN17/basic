package com.basic.reflection.proxy.dao;

public class UserDaoImpl implements UserDao {

	public void add() {
		System.out.println("添加功能");
	}

	public void delete() {
		System.out.println("删除功能");
	}

	public void update() {
		System.out.println("修改功能");
	}

	public void find() {
		System.out.println("查询功能");
	}

}
