package com.basic.io.common;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 1:可以操作任意类型的数据。
 *         print()
 *         println()
 * 2:启动自动刷新
 *         PrintWriter pw = new PrintWriter(new FileWriter("pw2.txt"), true);
 *         还是应该调用println()的方法才可以
 *         这个时候不仅仅自动刷新了，还实现了数据的换行。
 * 
 *         println()
 *        其实等价于于：
 *        bw.write();
 *        bw.newLine();        
 *        bw.flush();
 */
public class PrintWriterDemo2 {

	public static void main(String[] args) throws IOException{
		// 创建打印流对象
		PrintWriter pw = new PrintWriter(new FileWriter("fis.txt"), true);
		
//		pw.print(true);
//		pw.print(100);
//		pw.print("hello");
		
		pw.println("hello");
		pw.println(100);
		pw.println(true);
		
		pw.close();
	}
}
