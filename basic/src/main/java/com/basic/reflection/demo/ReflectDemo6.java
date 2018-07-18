package com.basic.reflection.demo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.basic.reflection.entity.Student;

/**
 * // 获取 Class 对象中指定函数名和参数的函数，参数一为函数名，参数 2 为参数类型列表
 * public Method getDeclaredMethod (String name, Class...<?> parameterTypes)
 * 
 * // 获取该 Class 对象中的所有函数( 不包含从父类继承的函数 )
 * public Method[] getDeclaredMethods ()
 * 
 * // 获取指定的 Class 对象中的**公有**函数，参数一为函数名，参数 2 为参数类型列表
 * public Method getMethod (String name, Class...<?> parameterTypes)
 * 
 * // 获取该 Class 对象中的所有**公有**函数 ( 包含从父类和接口类集成下来的函数 )
 * public Method[] getMethods ()
 * 
 * // 获取 Class 对象中指定属性名的属性，参数一为属性名
 * public Method getDeclaredField (String name)
 * 
 * // 获取该 Class 对象中的所有属性( 不包含从父类继承的属性 )
 * public Method[] getDeclaredFields ()
 * 
 * // 获取指定的 Class 对象中的**公有**属性，参数一为属性名
 * public Method getField (String name)
 * 
 * // 获取该 Class 对象中的所有**公有**属性 ( 包含从父类和接口类集成下来的公有属性 )
 * public Method[] getFields ()
 * 
 * @author robin
 *
 */
public class ReflectDemo6 {
	
	public static void main(String[] args) {
//		showDeclaredMethods();
		
//		showMethods();
		
//		showDeclaredFields();
		
//		showFields();
		
		showSuper();
		
		showInterfaces();
	}
	
	
	/**
	 * 获取当前类中定义的方法
	 * 
	 */
	private static void showDeclaredMethods() {
		Student student = new Student("mr.simple");
		Method[] methods = student.getClass().getDeclaredMethods();
		for(Method method : methods) {
			System.out.println("declared method name:" + method.getName());
		}
		
		try {
			Method learnMethod = student.getClass().getDeclaredMethod("learn", String.class);
			// 获取方法的参数类型列表
			Class<?>[] paramClasses = learnMethod.getParameterTypes();
			for(Class<?> class1 : paramClasses) {
				System.out.println("learn方法的参数类型:" + class1.getName());
			}
			
			// 是否是private函数，属性是否是private，也可以使用这种方式判断
			System.out.println(learnMethod.getName() + " is private: " + Modifier.isPrivate(learnMethod.getModifiers()));
			learnMethod.invoke(student, "java----> ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
	/**
	 * 获取当前类、父类中定义的公有方法
	 * 
	 * getDeclaredMethod 和 getDeclaredMethods 
	 * 包含 private、protected、default、public 的函数，
	 * 并且通过这两个函数获取到的只是在自身中定义的函数，从父类中集成的函数不能够获取到。
	 * 而 getMethod 和 getMethods 只包含 public 函数，
	 * 父类中的公有函数也能够获取到
	 */
	private static void showMethods() {
		Student student = new Student("mr.simple");
		// 获取所有方法
		Method[] methods = student.getClass().getMethods();
		for(Method method : methods) {
			System.out.println("method name : " + method.getName());
		}
		
		try {
			// 通过getMethod只能获取公有方法，如果获取私有方法则会抛出异常，比如这里就会抛异常
			Method learnMethod = student.getClass().getMethod("learn", String.class);
			// 是否是private函数，属性是否是private，也可以使用这种方式判断
			System.out.println(learnMethod.getName() + " is private " + Modifier.isPrivate(learnMethod.getModifiers()));
			// 调用learn函数
			learnMethod.invoke(student, "java");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 获取当前类中定义的属性
	 */
	private static void showDeclaredFields() {
		Student student = new Student("mr.simple");
		// 获取当前类和父类的所有公有属性
		Field[] publicFields = student.getClass().getDeclaredFields();
		for(Field field : publicFields) {
			System.out.println("declared field name : " + field.getName());
		}
		
		try {
			// 获取当前类和父类的某个公有属性
			Field gradeField = student.getClass().getDeclaredField("mGrade");
			// 不添加会报异常
			gradeField.setAccessible(true);
			// 获取属性值
			System.out.println(" my grade is : " + gradeField.getInt(student));
			// 设置属性值
			gradeField.set(student, 10);
			System.out.println(" my grade is :" + gradeField.getInt(student));
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	
	/**
	 * 获取当前类、父类中定义的公有属性
	 * 
	 * getDeclaredField 和 getDeclaredFields 
	 * 包含 private、protected、default、public 的属性，
	 * 并且通过这两个函数获取到的只是在自身中定义的属性，
	 * 从父类中集成的属性不能够获取到。而 getField 和 getFields 
	 * 只包含 public 属性，父类中的公有属性也能够获取到
	 */
	private static void showFields() {
		Student student = new Student("mr.simple");
		// 获取当前类和父类的所有公有属性
		Field[] publicFields = student.getClass().getFields();
		for(Field field : publicFields) {
			System.out.println("field name : " + field.getName());
		}
		
		try {
			// 获取当前类和父类的某个公有属性
			Field ageField = student.getClass().getField("mAge");
			System.out.println(" age is : " + ageField.getInt(student));
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	
	/**
	 * 获取父类
	 * 
	 */
	private static void showSuper() {
		Student student = new Student("mr.simple");
		Class<?> superClass = student.getClass().getSuperclass();
		while(superClass != null) {
			System.out.println("Student's super class is : " + superClass.getName());
			// 再获取父类的上一层父类，直到最后的 Object 类，Object 的父类为 null
			superClass = superClass.getSuperclass();
		}
	}
	
	
	/**
	 * 获取 Class 对象中实现的接口
	 */
	private static void showInterfaces() {
		Student student = new Student("mr.simple");
		Class<?>[] interfaceses = student.getClass().getInterfaces();
		for(Class<?> class1 : interfaceses) {
			System.out.println("Student's interface is : " + class1.getName());
		}
	}
	
	
	
	
}
