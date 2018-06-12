package com.basic.io.reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * InputStreamReader的方法：
 * int read():一次读取一个字符
 * int read(char[] chs):一次读取一个字符数组
 */
public class InputStreamReaderDemo {
	
	public static void main(String[] args) throws IOException {
		// 创建对象
		InputStreamReader isr = new InputStreamReader(new FileInputStream("fis.txt"));
		
		// 一次读取一个字节
//		int by = 0;
//		while((by = isr.read()) != -1) {
//			System.out.println((char)by);
//		}
		
		// 一次读取一个字符数组
		char[] chs = new char[1024];
		int len = 0;
		while((len = isr.read(chs)) != -1) {
			System.out.println(new String(chs, 0, len));
		}
		
		isr.close();
	}

}
