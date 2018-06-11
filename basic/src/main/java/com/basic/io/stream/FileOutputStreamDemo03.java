package com.basic.io.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 加入异常处理的字节输出流操作
 * 分开异常处理
 * 合并一起异常处理
 * 改进版异常处理
 */
public class FileOutputStreamDemo03 {
	
	public static void main(String[] args) {
//		// 分开异常处理
//		FileOutputStream fos = null;
//		try {
//			// 创建对象
//			fos = new FileOutputStream("fos.txt");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			// 写入数据
//			fos.write("hello world".getBytes());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			// 关闭流
//			fos.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		// 一起做异常处理
//		try {
//			FileOutputStream fos = new FileOutputStream("fos.txt");
//			fos.write("java".getBytes());
//			fos.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
		
		// 改进版异常处理
		// 为了在finally里面能够看到该对象就必须定义到外面，为了访问不出问题，还必须初始化
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("fos.txt");
			fos.write("hello 你好!".getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			// 判断fos是否为空，不为空就关闭
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
