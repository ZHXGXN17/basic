package com.basic.io.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 需求：把e:\\a.mp4复制到当前项目目录下的b.mp4中
 *
 * 字节流四种方式复制文件：
 * 基本字节流一次读写一个字节：    共耗时：117235毫秒  || 6377毫秒 
 * 基本字节流一次读写一个字节数组： 共耗时：156毫秒       || 12秒
 * 高效字节流一次读写一个字节： 共耗时：1141毫秒            || 64秒
 * 高效字节流一次读写一个字节数组： 共耗时：47毫秒           || 7秒
 */
public class CopyMp4Demo {
	
	public static void main(String[] args) throws IOException{
		long start = System.currentTimeMillis();
		System.out.println("start:" + start);
//		method1("fis.txt", "fos.txt");
//		method2("fis.txt", "fos.txt");
//		method3("fis.txt", "fos.txt");
		method4("fis.txt", "fos.txt");
		
		long end = System.currentTimeMillis();
		System.out.println("end:" + end);
		System.out.println("共耗时:" + (end - start) + "秒");
	}
	
	/**
	 * 基本字节流一次读写一个字节
	 * @param src
	 * @param dest
	 * @throws IOException
	 */
	public static void method1(String src, String dest) throws IOException{
		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos = new FileOutputStream(dest);
		
		int by = 0;
		while((by = fis.read()) != -1) {
			fos.write(by);
		}
		
		fos.close();
		fis.close();
	}
	
	/**
	 * 基本字节流一次读写一个字节数组
	 * @param src
	 * @param dest
	 * @throws IOException
	 */
	public static void method2(String src, String dest) throws IOException{
		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos = new FileOutputStream(dest);
		
		byte[] bys = new byte[1024];
		int len = 0;
		while((len = fis.read(bys)) != -1) {
			fos.write(bys, 0, len);
		}
		
		fis.close();
		fos.close();
	}
	
	/**
	 * 高效字节流，一次读取一个字节
	 * @param src
	 * @param dest
	 * @throws IOException
	 */
	public static void method3(String src, String dest) throws IOException{
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
		
		int by = 0;
		while((by = bis.read()) != -1) {
			bos.write(by);
		}
		
		bis.close();
		bos.close();
	}

	/**
	 * 高效字节流，一次读取一个字节数组
	 * @param src
	 * @param dest
	 * @throws IOException
	 */
	public static void method4(String src, String dest) throws IOException{
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
		
		byte[] bys = new byte[1024];
		int len = 0;
		while((len = bis.read(bys)) != -1) {
			bos.write(bys, 0, len);
		}
		
		bis.close();
		bos.close();
	}
}
