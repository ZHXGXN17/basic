package com.basic.io.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * BufferedReader
 * 从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的高效读取。 
 * 可以指定缓冲区的大小，或者可使用默认的大小。大多数情况下，默认值就足够大了。 
 * 
 * BufferedReader(Reader in)
 */
public class BufferedReaderDemo {
	
	public static void main(String[] args) throws IOException {
		// 创建字符缓冲输入流对象
		BufferedReader br = new BufferedReader(new FileReader("fis.txt"));
		
		// 方式1
//		int by = 0;
//		while((by = br.read()) != -1) {
//			System.out.println((char)by);
//		}
		
		// 方式2
		char[] ch = new char[1024];
		int len = 0;
		while((len = br.read(ch)) != -1) {
			System.out.println(new String(ch, 0, len));
		}
		
		br.close();
	}

}
