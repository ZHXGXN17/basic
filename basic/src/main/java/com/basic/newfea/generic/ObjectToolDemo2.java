package com.basic.newfea.generic;

/**
 * 泛型方法
 * 
 * public <T> T add(T x, T y){ 
 * 
   }
 * @author robin
 *
 */
public class ObjectToolDemo2 {
	
	public static void main(String[] args) {
		ObjectTool2 ot = new ObjectTool2();
		ot.show("hello");
		ot.show(100);
		ot.show(true);
		
		// 编译不通过
//		ObjectTool2<String> ot2 = new ObjectTool2<String>();
//		ot.show("hello");
		
//		 ObjectTool<Integer> ot2 = new ObjectTool<Integer>();
//       ot2.show(100);
        
//       ObjectTool<Boolean> ot3 = new ObjectTool<Boolean>();
//       ot3.show(true);

	}

}

// 泛型方法：把泛型定义在方法上
class ObjectTool2 {
	public <T> void show(T t) {
		System.out.println(t);
	}
}
