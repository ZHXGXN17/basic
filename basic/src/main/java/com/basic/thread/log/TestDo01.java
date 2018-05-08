package com.basic.thread.log;

public class TestDo01 {
	
	public static void main(String[] args) {
		// 打印起始时间
		System.out.println("begin:" + (System.currentTimeMillis() / 1000));
		
		for(int i = 0;i < 10;i++) {
			String input = i + "";
			String output = TestDo.doSome(input);
			System.out.println(Thread.currentThread().getName() + ":" + output);
		}
	}

}


/**
 * 不能改动此TestDo类
 */
class TestDo{
	public static String doSome(String input) {
		try {
			Thread.sleep(100);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		String output = input + ":" + (System.currentTimeMillis() / 1000);
		return output;
	}
}

