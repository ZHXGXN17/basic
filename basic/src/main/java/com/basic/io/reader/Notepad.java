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

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.println("--1:新建文件 2:打开文件  3:修改文件  4:保存 5:退出--");
		while(true) {
			System.out.println("请输入操作指令!");
			int command = sc.nextInt();
			switch(command) {
			case 1:
				createFile();
				break;
			case 2:
				openFile();
				break;
			case 3:
				editFile();
				break;
			case 4:
				saveFile();
				break;
			case 5:
				exit();
				break;
			default:
				System.out.println("您输入的指令有误,请重新输入!");
				break;
			}
		}
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
	
	
	/**
	 * 打开文件
	 * @throws Exception
	 */
	private static void openFile() throws Exception{
		// 打开文件时，暂存内容清空
		message = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入打开文件的位置:");
		// 获取打开文件路径
		filePath = sc.nextLine();
		// 控制只能输入txt格式的文件路径
		if(filePath != null && !filePath.endsWith(".txt")) {
			System.out.println("请选择文本文件");
			return;
		}
		// 实例化一个FileReader对象
		FileReader fr = new FileReader(filePath);
		char[] ch = new char[1024];
		int len = 0;
		StringBuffer sb = new StringBuffer();
		// 循环读取，一次读取一个字符数组
		while((len = fr.read(ch)) != -1) {
			sb.append(ch);
		}
		
		// 将打开文件内容暂存
		System.out.println("打开文件内容:" + "\r\n" + message);
		fr.close();
	}
	
	
	/**
	 * 修改文件内容，通过字符串替换的形式
	 */
	private static void editFile() {
		if(message == "" && filePath == null) {
			System.out.println("请先新建文件或者打开文件");
			return;
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入要修改的内容(以\"修改的目标文件:修改之后的文字\"格式)," + "停止修改请输入\"stop\":");
		
		String inputMessage = "";
		// 当输入stop时，停止修改
		while(!inputMessage.equals("stop")) {
			inputMessage = sc.nextLine();
			if(inputMessage != null && inputMessage.length() > 0) {
				// 将输入的文字根据“:” 拆分成数组
				String[] editMessage = inputMessage.split(":");
				if(editMessage != null && editMessage.length > 1) {
					// 根据输入的信息将文件中内容进行替换
					message = message.replace(editMessage[0], editMessage[1]);
				}
			}
		}
		System.out.println("修改后的内容:" + "\r\n" + message);
	}
	
	
	/**
	 * 保存 新建文件存在用户输入的路径 打开的文件将原文件覆盖
	 * @throws IOException
	 */
	private static void saveFile() throws IOException{
		Scanner sc = new Scanner(System.in);
		FileWriter out = null;
		// 文件是由"打开"载入的
		if(filePath != null) {
			// 将源文件覆盖
			out = new FileWriter(filePath);
		}else {
			System.out.println("请输入文件保存的绝对路径:");
			String path = sc.next();
			filePath = path;
			// 将输入路径中大写字符替换成小写字母后判断是不是文本格式
			if(!filePath.toLowerCase().endsWith(".txt")) {
				filePath += ".txt";
			}
			// 构造输出流
			out = new FileWriter(filePath);
		}
		
		// 写入暂存的内容
		out.write(message);
		// 关闭输出流
		out.close();
		// 修改文件前将现写入内容置空
		message = "";
		// 将文件路径置为null
		filePath = "";
	}
	
	
	/**
	 * 退出
	 */
	private static void exit() {
		System.out.println("您已退出系统，谢谢您的使用!");
		System.exit(0);
	}
	
}
