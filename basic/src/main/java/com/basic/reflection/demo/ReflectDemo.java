package com.basic.reflection.demo;

import com.basic.reflection.entity.Person01;

/**
 * 反射：就是通过class文件对象，去使用该文件中的成员变量，构造方法，成员方法。
 * 
 * Person01 p = new Person01(); p.使用
 * 
 * 要想这样使用，首先你必须得到class文件对象，其实也就是得到class类的对象，
 * Class 类       成员变量   Field  构造方法 Constructor 成员方法 Method
 * 
 * 获取class文件对象的方式：
 *   A：Object类的getClass()方法
 *   B:数据类型的静态属性class
 *   C:Class类中的静态方法public static Class forName(String className)
 *   
 *   一般我们到底使用谁呢，第三种：因为第三种是一个字符串，而不是一个具体的类名，这样我们就可以把这样的字符串配置到配置文件中
 * 
 * @author robin
 *
 */
public class ReflectDemo {
	
	public static void main(String[] args) throws ClassNotFoundException {
		// 方式1
		Person01 p = new Person01();
		Class c = p.getClass();
		
		Person01 p2 = new Person01();
		Class c2 = p2.getClass();
		
		System.out.println(p == p2); // false
		System.out.println(c == c2); // true
		
		// 方式2
		Class c3 = Person01.class;
		// int.class
		// String.class
		System.out.println(c == c3); // true
		
		// 方式3
		// ClassNotFoundException
		Class c4 = Class.forName("com.basic.reflection.entity.Person01");
		System.out.println(c == c4); // true
	}

}
