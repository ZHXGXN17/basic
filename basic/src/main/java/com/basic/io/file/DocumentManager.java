package com.basic.io.file;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import com.basic.io.util.FileUtils;

public class DocumentManager {
	
	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);
		System.out.println("--1:指定关键字检索文件 2:指定后缀名检索文件 " + "3:复制文件/目录 4:退出--");
		while(true) {
			System.out.println("请输入指令!");
			int command = scanner.nextInt();
			switch(command) {
			case 1:
				// 指定关键字检索文件
				searchByKeyWorld();
			    break;
			case 2:
				// 指定后缀名检索文件
				searchBySuffix();
				break;
			case 3:
				// 复制文件/目录
				copyDirectory();
				break;
			case 4:
				// 退出
				exit();
				break;
			default:
				System.out.println("您输入的指令错误!");
				break;
			}
		}
	}
	
	
	// ******************1.指定关键字检索文件**************************
	private static void searchByKeyWorld() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入要检索的目录位置:");
		// 从控制台获取路劲
		String path = sc.next();
		File file = new File(path);
		
		// 判断目录是否存在，是否是目录
		if(!file.exists() || !file.isDirectory()) {
			System.out.println(path + "不是有效目录!");
			return;
		}
		System.out.println("请输入搜索关键字!");
		// 获取关键字
		String key = sc.next();
		// 在输入目录下获取所有包含关键字的文件路径
		ArrayList<String> list = FileUtils.listFiles(file, key);
		for(Object obj : list) {
			System.out.println(obj);
		}
	}
	
	
	// ******************2.指定后缀名检索文件**************************
	private static void searchBySuffix() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入要检索的目录位置!");
		// 从控制台获取路径
		String path = sc.next();
		File file = new File(path);
		// 判断目录是否存在，是否是目录
		if(!file.exists() || !file.isDirectory()) {
			System.out.println(path + "不是有效目录");
			return;
		}
		System.out.println("请输入搜索后缀:");
		String suffix = sc.next();
		// 获取后缀字符串
		String[] suffixArray = suffix.split(",");
		// 在输入目录下获取所有指定后缀名的文件路径
		ArrayList<String> list = FileUtils.listFiles(file, suffixArray);
		for(Object obj : list){
			System.out.println(obj);
		}
	}
	
	
	// ******************3.复制文件/目录**************************
	private static void copyDirectory() throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入源目录:");
		// 源路径
		String srcDirectory = sc.next();
		File srcFile = new File(srcDirectory);
		if(!srcFile.exists() || !srcFile.isDirectory()) {
			System.out.println("无效目录!");
			return;
		}
		System.out.println("请输入目标位置:");
		// 目标路径
		String destDirectory = sc.next();
		File destFile = new File(destDirectory);
		if(!destFile.exists() || !destFile.isDirectory()) {
			System.out.println("无效位置!");
			return;
		}
		// 将源路径中的内容复制到目标路径下
		FileUtils.copySrcPathToDestPath(srcFile, destFile);
	}
	
	
	// ******************4.退出**************************
	private static void exit() {
		System.out.println("您已退出系统，谢谢使用");
		System.exit(0);
	}
}
