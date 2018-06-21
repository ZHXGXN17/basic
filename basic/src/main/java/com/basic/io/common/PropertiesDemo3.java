package com.basic.io.common;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Properties;

/**
 * 这里的集合必须是Properties集合：
 * public void load(Reader reader):把文件中的数据读取到集合中
 * public void store(Writer writer,String comments):把集合中的数据存储到文件
 * 
 * 单机版游戏：
 *         进度保存和加载。
 *         三国群英传，三国志，仙剑奇侠传...
 * 
 *         吕布=1
 *         方天画戟=1
 */
public class PropertiesDemo3 {
	public static void main(String[] args) throws IOException{
//		store();
		myLoad();
	}
	
	private static void store() throws IOException{
		// 创建集合对象
		Properties prop = new Properties();
		
		prop.setProperty("it001", "hello");
		prop.setProperty("it002", "java");
		prop.setProperty("it003", "world");
		
		// public void store(Writer writer,String comments):把集合中的数据存储到文件
		Writer w = new FileWriter("fis.txt");
		prop.store(w, "世界杯最好的C罗");
		w.close();
	}

	private static void myLoad() throws IOException{
		Properties prop = new Properties();
		
		// public void load(Reader reader):把文件中的数据读取到集合中
        // 注意：这个文件的数据必须是键值对形式
		Reader read = new FileReader("fis.txt");
		prop.load(read);
		read.close();
		
		System.out.println("prop:" + prop);
	}
}
