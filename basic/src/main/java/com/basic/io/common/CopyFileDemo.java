package com.basic.io.common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 需求：DataStreamDemo.java复制到Copy.java中
 * 数据源：
 *         DataStreamDemo.java -- 读取数据 -- FileReader -- BufferedReader
 * 目的地：
 *         Copy.java -- 写出数据 -- FileWriter -- BufferedWriter -- PrintWriter
 */
public class CopyFileDemo {
	
	public static void main(String[] args) throws IOException{
		// 以前的版本
        // 封装数据源
        // BufferedReader br = new BufferedReader(new FileReader(
        // "DataStreamDemo.java"));
        // // 封装目的地
        // BufferedWriter bw = new BufferedWriter(new FileWriter("Copy.java"));
        //
        // String line = null;
        // while ((line = br.readLine()) != null) {
        // bw.write(line);
        // bw.newLine();
        // bw.flush();
        // }
        //
        // bw.close();
        // br.close();

        // 打印流的改进版
        // 封装数据源
		BufferedReader br = new BufferedReader(new FileReader("fos.txt"));
		
		// 封装目的地
		PrintWriter pw = new PrintWriter(new FileWriter("fis.txt"), true);
		
		String line = null;
		while((line = br.readLine()) != null) {
			pw.println(line);
		}
		
		pw.close();
		br.close();
	}

}
