package com.basic.io.stream;

import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 字节输出流操作步骤：
 * A:创建字节输出流对象
 * B:调用write()方法
 * C:释放资源
 *
 * public void write(int b):写一个字节
 * public void write(byte[] b):写一个字节数组
 * public void write(byte[] b,int off,int len):写一个字节数组的一部分
 */
public class FileOutputStreamDemo02 {
	
	public static void main(String[] args) throws IOException {
		// 创建字节输出流对象
		FileOutputStream fos = new FileOutputStream("fos.txt");
		fos.write(97);
		
		byte[] bys = {98, 99, 100, 101, 102};
		fos.write(bys);
		fos.write(bys, 1, 3);
		
		// 释放资源
		fos.close();
	}

}
