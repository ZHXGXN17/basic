package com.basic.io.common;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 可以读写基本数据类型的数据
 * 数据输入流：DataInputStream
 *             DataInputStream(InputStream in)
 * 数据输出流：DataOutputStream
 *             DataOutputStream(OutputStream out) 
 */
public class DataStreamDemo {
	
	public static void main(String[] args) throws IOException{
		read();
		write();
	}

	public static void read() throws IOException{
		// 创建数据输入流对象
		DataInputStream dis = new DataInputStream(new FileInputStream("fis.txt"));
		
		// 读数据
		byte b = dis.readByte();
		short s = dis.readShort();
		int i = dis.readInt();
		long l = dis.readLong();
		float f = dis.readFloat();
		double d = dis.readDouble();
		char c = dis.readChar();
		boolean bb = dis.readBoolean();
		
		// 释放资源
		dis.close();
		
		System.out.println("b:" + b);
		System.out.println("s:" + s);
		System.out.println("i:" + i);
		System.out.println("l:" + l);
		System.out.println("f:" + f);
		System.out.println("d:" + d);
		System.out.println("c:" + c);
		System.out.println("bb:" + bb);
	}
	
	
	public static void write() throws IOException{
		// 创建数据输出流对象
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("fis.txt"));
		
		// 写入数据
		dos.writeByte(10);
		dos.writeShort(100);
		dos.writeInt(1000);
		dos.writeLong(10000);
		dos.writeFloat(12.34F);
		dos.writeDouble(12.56);
		dos.writeChar('a');
		dos.writeBoolean(true);
		
		dos.close();
	}
	
}
