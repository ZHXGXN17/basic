package com.basic.io.reader;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 需求：把当前项目目录下的a.txt内容复制到当前项目目录下的b.txt中
 * 
 * 数据源：
 *         a.txt -- 读取数据 -- 字符转换流 -- InputStreamReader
 * 目的地：
 *         b.txt -- 写出数据 -- 字符转换流 -- OutputStreamWriter
 */
public class CopyFileDemo {
	
	public static void main(String[] args) throws IOException {
		// 封装数据源
		InputStreamReader isr = new InputStreamReader(new FileInputStream("fos.txt"));
		
		// 封装目的地
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("fis.txt"));
		
		// 读写数据，方式一
//		int by = 0;
//		while((by = isr.read()) != -1) {
//			osw.write(by);
//		}
		
		// 方式二
		char[] chs = new char[1024];
		int len = 0;
		while((len = isr.read(chs)) != -1) {
			osw.write(chs, 0, len);
		}
		
		isr.close();
		osw.close();
	}

}
