package com.basic.newfea.generic;

/**
 * 泛型接口      格式:public interface 接口名<泛型类型1…>
 * 
 * @author robin
 *
 */
public class InterDemo {
	public static void main(String[] args) {
		// 第一种情况测试
		Inter<String> i = new InterImpl();
		i.show("hello");
		
		// 第二种测试
		Inter<String> i2 = new InterImpl2<String>();
		i2.show("hello");
		
		Inter<Integer> i3 = new InterImpl2<Integer>();
		i3.show(100);
	}

}

// 泛型接口：把泛型定义在接口上 
interface Inter<T> {
  public abstract void show(T t);
}

/**
 * 实现类在实现接口的时候
 * 第一种情况：已经直到该是什么类型了
 *
 */
class InterImpl implements Inter<String>{
	public void show(String t) {
		System.out.println(t);
	}
}

// 第二种情况：还不知道是什么类型的
class InterImpl2<T> implements Inter<T> {
	public void show(T t) {
		System.out.println(t);
	}
}
