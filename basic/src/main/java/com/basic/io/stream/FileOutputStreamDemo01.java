package com.basic.io.stream;

import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 需求：我要往一个文本文件中输入一句话："hello,io"
 *
 * 分析：
 *   A:这个操作最好是采用字符流来做，但是呢，字符流是在字节流之后才出现的，所以，今天先尝试字节流如何操作。
 *   B:由于我是要往文件中写一句话，所以我们要采用字节输出流。
 */
public class FileOutputStreamDemo01 {
	
	public static void main(String[] args) throws IOException {
		/**
		 * 创建字节输出流对象
		 * A:调用系统功能去创建文件
		 * B:创建fos对象
		 * C:把fos对象指向这个文件
		 */
		FileOutputStream fos = new FileOutputStream("fos.txt");
		// 写数据
		fos.write("hello world".getBytes());
		fos.write("java".getBytes());
		// 关闭流
		fos.close();
	}

}
