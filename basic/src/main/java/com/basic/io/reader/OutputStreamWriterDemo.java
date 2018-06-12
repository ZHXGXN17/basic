package com.basic.io.reader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * OutputStreamWriter的方法：
 * public void write(int c):写一个字符
 * public void write(char[] cbuf):写一个字符数组
 * public void write(char[] cbuf,int off,int len):写一个字符数组的一部分
 * public void write(String str):写一个字符串
 * public void write(String str,int off,int len):写一个字符串的一部分
 */
public class OutputStreamWriterDemo {
	
	public static void main(String[] args) throws IOException {
		// 创建对象
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("fis.txt"));
		
		// 写数据, public void write(int c):写一个字符
//		osw.write('a');
//		osw.write(97);
		// 但是数据没有存入进去，原因，字符=2字节,文件中数据存储的基本单位是字节，需要刷新缓冲区
		
		// public void write(char[] cbuf):写一个字符数组
//		char[] chs = {'a','b','c','d','e'};
//		osw.write(chs);
		
		// public void write(char[] cbuf,int off,int len):写一个字符数组的一部分
//      osw.write(chs,1,3);
		
		// public void write(String str):写一个字符串
//		osw.write("笑傲江湖");
		
		// public void write(String str,int off,int len):写一个字符串的一部分
		osw.write("笑傲江湖", 0, 2);
		
		// 刷新
		osw.flush();
		
		osw.write("hello world");
		
		// 关闭流
		osw.close();
		// java.io.IOException: Stream closed
		osw.write("天龙八部");
	}

}
