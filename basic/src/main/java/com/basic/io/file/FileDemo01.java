package com.basic.io.file;

import java.io.File;

/*
 * 我们要想实现IO的操作，就必须知道硬盘上文件的表现形式。
 * 而Java就提供了一个类File供我们使用。
 * 
 * File:文件和目录(文件夹)路径名的抽象表示形式
 * 构造方法：
 *         File(String pathname)：根据一个路径得到File对象
 *         File(String parent, String child):根据一个目录和一个子文件/目录得到File对象
 *         File(File parent, String child):根据一个父File对象和一个子文件/目录得到File对象
 */
public class FileDemo01 {
	
	public static void main(String[] args) {
		// File(String pathname)：根据一个路径得到File对象
		File file = new File("E:\\ip\\Ip地址库_20170727\\4-mobile.csv");
		
        // File(String parent, String child):根据一个目录和一个子文件/目录得到File对象
		File file2 =  new File("E:\\ip\\Ip地址库_20170727", "4-mobile.csv");
		
		File file3 = new File("e:\\ip\\Ip地址库_20170727");
		File file4 = new File(file3, "4-mobile.csv");
	}

}
