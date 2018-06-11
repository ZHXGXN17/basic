package com.basic.io.stream;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 字节输入流操作步骤：
 * A:创建字节输入流对象
 * B:调用read()方法读取数据，并把数据显示在控制台
 * C:释放资源
 *
 * 读取数据的方式：
 * A:int read():一次读取一个字节
 * B:int read(byte[] b):一次读取一个字节数组
 * C:int read(byte[] b):一次读取一个字节数组
 *   返回值其实是实际读取的字节个数。
 */
public class FileInputStreamDemo01 {
	public static void main(String[] args) throws IOException{
		FileInputStream fis = new FileInputStream("fos.txt");
//		// 调用read()方法读取数据，并把数据显示在控制台
//        // 第一次读取
//		int by = fis.read();
//		System.out.println(by);
//		System.out.println((char)by);
//		
//		// 第二次读取
//		by = fis.read();
//		System.out.println(by);
//		System.out.println((char)by);
//		
//		// 第三次读取
//		by = fis.read();
//		System.out.println(by);
//		System.out.println((char)by);
		
		// 通过测试，我们知道如果你读取的数据是-1，就说明已经读取到文件的末尾了
		// 循环改进
//		int by = fis.read();
//		while(by != -1) {
//			System.out.println((char)by);
//			by = fis.read();
//		}
		
		// 最终版代码
		int by = 0;
		while((by = fis.read()) != -1) {
			System.out.println((char)by);
		}
		
		// 数组的长度一般是1024或者1024的整数倍
		byte[] bys = new byte[1024];
		int len;
		while((len = fis.read(bys)) != -1) {
			System.out.println(new String(bys, 0, len));
		}
		
		// 关闭流
		fis.close();
	}

}
