package com.basic.io.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/*
 * 内存操作流：用于处理临时存储信息的，程序结束，数据就从内存中消失。
 * 字节数组：
 *         ByteArrayInputStream
 *         ByteArrayOutputStream
 * 字符数组：
 *         CharArrayReader
 *         CharArrayWriter
 * 字符串：
 *         StringReader
 *         StringWriter
 */
public class ByteArrayStreamDemo {

	public static void main(String[] args) throws IOException{
		// 写数据
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		// 写数据
		for(int i = 0;i < 10;i++) {
			bos.write(("hello" + i).getBytes());
		}
		
		// public byte[] toByteArray()
		byte[] bys = bos.toByteArray();
		
		// 读数据
        // ByteArrayInputStream(byte[] buf)
		ByteArrayInputStream bais = new ByteArrayInputStream(bys);
		
		int by = 0;
		while((by = bais.read()) != -1) {
			System.out.println((char)by);
		}
	}
	
}
