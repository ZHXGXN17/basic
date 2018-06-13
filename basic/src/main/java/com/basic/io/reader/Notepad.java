/*
 ***************************************************************************************
 * All rights Reserved, Designed By www.zzcx.com.cn
 * @Title:  Notepad.java   
 * @Package com.basic.io.reader   
 * @Description: (用一句话描述该文件做什么)   
 * @author: wangyf
 * @date:   2018-6-13 8:36:05   
 * @version V1.0 
 * @Copyright: 2018  智卓创新(北京)信息产业股份有限公司. All rights reserved. 
 * 注意：本内容仅限于公司内部使用，禁止外泄以及用于其他的商业目
 *  ---------------------------------------------------------------------------------- 
 * 文件修改记录
 *     文件版本：         修改人：             修改原因：
 ***************************************************************************************
 */
package com.basic.io.reader;

import java.util.Scanner;

/**
 * 模拟记事本
 * @author robin
 *
 */
public class Notepad {
	
	/** 文件路径. */
	private static String filePath;
	
	/** 文件内容. */
	private static String message = "";
	
	public static void main(String[] args) {
		
	}
	
	/**
	 * 新建文件，从控制台获取内容
	 */
	private static void createFile() {
		// 新建文件，暂存文件内容为空
		message = "";
		Scanner sc = new Scanner(System.in);
		// 提示
		System.out.println("请输入内容，停止编写请输入\"stop\":");
		// 输入内容拼接
		StringBuffer stb = new StringBuffer();
		String inputMessage = "";
		// 输入stop，停止输入
		while(!inputMessage.equals("stop")) {
			if(stb.length() > 0) {
				// 换行
				stb.append("\r\n");
			}
			stb.append(inputMessage);
			inputMessage = sc.nextLine();
		}
		// 暂存输入内容
		message = stb.toString();
	}
	
	private static void openFile() throws Exception{
		// 打开文件时，暂存内容清空
		message = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入打开文件的位置:");
		filePath = sc.nextLine();
	}

}
