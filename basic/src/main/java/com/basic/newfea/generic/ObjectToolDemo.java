package com.basic.newfea.generic;

/**
 * 泛型类
 * 
 * class A<T> {
 *      private T bean;//泛型可在成员变量上使用
 *      public T fun(T t) {}//泛型可以在类中的方法上（返回值和参数类型）使用！
 *      public void fun2() {//泛型还可以在局部变量的引用类型上使用
 *          T b = ...
 *          new T();//不行的！
 *      }
 * }
 * 
 * @author robin
 *
 */
public class ObjectToolDemo {
	
	public static void main(String[] args) {
//		ObjectTool ot = new ObjectTool();
//		
//		// String
//		ot.setObj(new String("风清扬"));
//		String str = (String)ot.getObj();
//		System.out.println("姓名是:" + str);
//		
//		// int
//		ot.setObj(new Integer(30));
//		Integer i = (Integer)ot.getObj();
//		System.out.println("年龄是：" + i);
//		
//		// 构造异常
//		ot.setObj(new String("林青霞"));
//		// java.lang.ClassCastException
//		Integer ii = (Integer)ot.getObj();
//		System.out.println("姓名是:" + ii);
		
		System.out.println("----------------");
		ObjectTool<String> ot = new ObjectTool<String>();
		// 这个时候编译期间就过不去了
//		ot.setObj(new Integer(27));
		ot.setObj(new String("林青霞"));
		String str = ot.getObj();
		System.out.println("姓名是:" + str);
		
		ObjectTool<Integer> ot2 = new ObjectTool<Integer>();
        // ot2.setObj(new String("风清扬"));//这个时候编译期间就过不去
        ot2.setObj(new Integer(27));
        Integer i = ot2.getObj();
        System.out.println("年龄是：" + i);
		
	}

}

// 泛型类：把泛型定义在类上
class ObjectTool<T> {
	private T obj;
	
	public T getObj() {
		return obj;
	}
	
	public void setObj(T obj) {
		this.obj = obj;
	}
}
