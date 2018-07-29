package com.basic.gson.third;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import com.basic.gson.first.entity.Category;
import com.basic.gson.first.entity.ModifierSample;
import com.basic.gson.first.entity.SinceUntilSample;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

public class GsonDemo03 {
	
	public static void main(String[] args) {
//		read();
//		sineUtilTest(1);
//		modifier();
		strategory();
	}
	
	/**
	 * 基于@Expose注解,不输出业务字段
	 * 
	 */
	public static void read() {
		List<Category> list = new ArrayList<Category>();
		Category category = new Category();
		category.setId(100);
		category.setName("笔记本");
		list.add(category);
		
		category.setId(101);
		category.setName("台式机");
		list.add(category);
		
		Category categoryList = new Category();
		categoryList.setId(1);
		categoryList.setName("电脑");
		categoryList.setChildren(list);
		
		System.out.println(categoryList);
		Gson gson = new GsonBuilder()
				    .excludeFieldsWithoutExposeAnnotation()
				    .setPrettyPrinting()
				    .create();
		System.out.println(gson.toJson(categoryList));
	}
	
	
	/**
	 * 基于版本
	 * 当前版本(GsonBuilder中设置的版本) 大于等于Since的值时该字段导出，小于Until的值时该该字段导出
	 */
	public static void sineUtilTest(double version) {
		SinceUntilSample sinceUntilSample = new SinceUntilSample();
		sinceUntilSample.since = "since";
		sinceUntilSample.until = "until";
		
		Gson gson = new GsonBuilder().setVersion(version).create();
		// 当version <4时，结果：{"until":"until"}
		// 当version >=4 && version <5时，结果：{"since":"since","until":"until"}
		// 当version >=5时，结果：{"since":"since"}
		System.out.println(gson.toJson(sinceUntilSample));
	}
	
	
	/**
	 * 基于访问修饰符
	 * 
	 */
	public static void modifier() {
		ModifierSample modifierSample = new ModifierSample();
		Gson gson = new GsonBuilder()
				.excludeFieldsWithModifiers(Modifier.FINAL, Modifier.STATIC, Modifier.PRIVATE)
				.create();
		System.out.println(gson.toJson(modifierSample));
		// {"publicField":"public","protectedField":"protected","defaultField":"default"}
	}

	public static void strategory() {
		List<Category> list = new ArrayList<Category>();
		Category category = new Category();
		category.setId(100);
		category.setName("笔记本");
		list.add(category);
		
		category.setId(101);
		category.setName("台式机");
		list.add(category);
		
		Category categoryList = new Category();
		categoryList.setId(1);
		categoryList.setName("电脑");
		categoryList.setChildren(list);
		
		Gson gson = new GsonBuilder()
				    .addSerializationExclusionStrategy(new ExclusionStrategy() {

						@Override
						public boolean shouldSkipClass(Class<?> clazz) {
							// 直接排除某个类，return true为排除
							return (clazz == int.class || clazz == Integer.class);
						}

						@Override
						public boolean shouldSkipField(FieldAttributes f) {
							// 这里作判断，决定要不要排除该字段，return true为排除
							if("finalField".equals(f.getName())) {
								// 按字段名排除
								return true;
							}
							Expose expose = f.getAnnotation(Expose.class);
							if(expose != null && expose.deserialize() == false) {
								// 按注解排除
								return true;
							}
							return false;
						}
				    	
				    })
				    .create();
		System.out.println(gson.toJson(categoryList));
	}
}
