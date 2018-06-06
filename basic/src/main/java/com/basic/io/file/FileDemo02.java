package com.basic.io.file;

import java.io.File;

/*
 * 高级获取功能：
 * public String[] list():获取指定目录下的所有文件或者文件夹的名称数组
 * public File[] listFiles():获取指定目录下的所有文件或者文件夹的File数组
 */
public class FileDemo02 {
	
	public static void main(String[] args) {
		// 指定一个目录
		File file = new File("e:\\");
		
        // public String[] list():获取指定目录下的所有文件或者文件夹的名称数组
        String[] strArray = file.list();
        // 遍历
        for(String str : strArray) {
        	System.out.println("str:" + str);
        }
        
        // public File[] listFiles():获取指定目录下的所有文件或者文件夹的File数组
        File[] fileArray = file.listFiles();
        // 遍历
        for(File f : fileArray) {
        	System.out.println("f:" + f);
        }
	}

}
