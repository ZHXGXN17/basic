package com.basic.thread.pro_con;

public class StudentTest01 {
	
	public static void main(String[] args){
		// 创建资源
        Student01 s = new Student01();

        // 设置和获取的类
        SetThread01 st = new SetThread01(s);
        GetThread01 gt = new GetThread01(s);

        // 线程类
        Thread t1 = new Thread(st);
        Thread t2 = new Thread(gt);

        // 启动线程
        t1.start();
        t2.start();
	}

}
