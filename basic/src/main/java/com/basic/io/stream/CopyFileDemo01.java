package com.basic.io.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 需求：把c盘下的a.txt的内容复制到d盘下的b.txt中
 *
 * 数据源：
 *         c:\\a.txt    --    读取数据--    FileInputStream
 * 目的地：
 *         d:\\b.txt    --    写出数据    --    FileOutputStream
 */
public class CopyFileDemo01 {
	
	public static void main(String[] args) throws IOException{
		// 封装数据源
		FileInputStream fis = new FileInputStream("C:\\Users\\robin\\Desktop\\temp\\180608\\db\\风险预警一期签约表结构数据.txt");
		// 封装目的文件
		FileOutputStream fos = new FileOutputStream("fis.txt");
		
		// 复制数据
		int by = 0;
		while((by = fis.read()) != -1) {
			fos.write(by);
		}
		
		// 关闭流
		fis.close();
		fos.close();
	}

}
