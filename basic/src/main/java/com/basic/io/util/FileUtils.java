package com.basic.io.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class FileUtils {
	
	/**
	 * 指定关键字检索文件
	 * @param file File对象
	 * @param key 关键字
	 * @return 包含关键字的文件路径
	 */
	public static ArrayList<String> listFiles(File file, final String key){
		// 创建文件过滤器对象
		FilenameFilter filter = new FilenameFilter() {
			// 实现accept()方法
			public boolean accept(File dir, String name) {
				File currFile = new File(dir, name);
				// 如果文件名包含关键字返回true，否则返回false
				if(currFile.isFile() && name.contains(key)) {
					return true;
				}
				return false;
			}
		};
		
		// 递归方式获取指定的路径
		ArrayList<String> list = fileDir(file, filter);
		return list;
	}
	
	
	/**
	 * 指定后缀名检索文件
	 * @param file File对象
	 * @param suffixArray 后缀名数组
	 * @return 指定后缀名的文件路径
	 */
	public static ArrayList<String> listFiles(File file, final String[] suffixArray){
		// 创建过滤器对象
		FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				// 实现accept()方法
				File currFile = new File(dir, name);
				// 判断文件名以指定后缀名结尾返回true，否则返回false
				if(currFile.isFile()) {
					for(String suffix : suffixArray) {
						if(name.endsWith("." + suffix)) {
							return true;
						}
					}
				}
				return false;
			}
		};
		// 递归方式获取规定路径
		ArrayList<String> arrayList = fileDir(file, filter);
		return arrayList;
	}

	
	/**
	 * 递归方式获取指定的路径
	 * @param dir  File对象
	 * @param filter 过滤器
	 * @return 过滤器过滤的文件路径
	 */
	public static ArrayList<String> fileDir(File dir, FilenameFilter filter){
		ArrayList<String> arrayList = new ArrayList<String>();
		// 获取过滤后的所有文件数组
		File[] lists = dir.listFiles(filter);
		// 遍历文件数组
		for(File file : lists) {
			// 将文件的绝对路径放到集合中
			arrayList.add(file.getAbsolutePath());
		}
		// 获取当前目录下所有文件数组
		File[] files = dir.listFiles();
		// 遍历当前目录下所有文件数组
		for(File file : files) {
			if(file.isDirectory()) {
				// 如果是目录，递归调用fileDir()
				ArrayList<String> every = fileDir(file, filter);
				// 将文件夹下的文件路径添加到集合中
				arrayList.addAll(every);
			}
		}
		// 此时的集合中有当前目录下的文件路径，和当前目录的子目录下的文件路径
		return arrayList;
	}
	

	/**
	 * 复制文件/目录
	 * @param srcDir 源目录
	 * @param destDir 目标目录
	 * @throws Exception
	 */
	public static void copySrcPathToDestPath(File srcDir, File destDir) throws Exception{
		// 子文件目录
		File[] files = srcDir.listFiles();
		for(int i = 0; i < files.length; i++) {
			// 创建指定目录的文件
			File copiedFile = new File(destDir, files[i].getName());
			// 如果是目录
			if(files[i].isDirectory()) {
				// 创建文件夹
				if(!copiedFile.mkdirs()) {
					System.out.println("无法创建:" + copiedFile);
					return;
				}
				// 递归调用，获取子文件夹下的文件路径
				copySrcPathToDestPath(files[i], copiedFile);
			}else {
				// 复制文件
				// 获取输入流
				FileInputStream input = new FileInputStream(files[i]);
				// 获取输出流
				FileOutputStream output = new FileOutputStream(copiedFile);
				// 创建缓冲区
				byte[] buffer = new byte[1024];
				int n = 0;
				// 循环读取字节
				while((n = input.read(buffer)) != -1) {
					output.write(buffer, 0, n);
				}
				// 关闭输入、输出流
				input.close();
				output.close();
			}
		}
	}

}
