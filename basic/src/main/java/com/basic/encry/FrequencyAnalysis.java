package com.basic.encry;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 频率分析法破解凯撒密码.
 *
 * @ClassName:  FrequencyAnalysis
 * @author: wangyf
 * @date:   2018-7-10 8:02:40
 * @since:  v1.0
 */
public class FrequencyAnalysis {
	
	/** 统计英文中出现次数最多的字符. */
	private static final char MAGIC_CHAR = 'e';
	
	/** 破解生成的最大文件数. */
	private static final int DE_MAX_FILE = 4;

	/**
	 * 打印输出path路径下文件中字符对应出现的次数
	 * 
	 * @param path
	 * @throws IOException
	 */
	public static void printCharCount(String path) throws IOException{
		String data = file2String(path);
		List<Entry<Character, Integer>> mapList = getMaxCountChar(data);
		for(Entry<Character, Integer> entry : mapList) {
			// 输出前几位的统计信息
			System.out.println("字符'" + entry.getKey() + "'出现" + entry.getValue() + "次");
		}
	}
	
	
	/**
	 * 加密并保存加密后的文件
	 * 
	 * @param srcFile 源文件
	 * @param destFile 目标文件
	 * @param key 秘钥
	 * @throws IOException
	 */
	public static void encryptFile(String srcFile, String destFile, int key) throws IOException{
		String artile = file2String(srcFile);
		// 加密文件
		String encryptData = MyEncrypt.encrypt(artile, key);
		// 保存加密后的文件
		string2File(encryptData, destFile);
	}
	
	
	/**
	 * 破解凯撒密码
	 * 
	 * @param input 数据源
	 * @param destPath 返回解密后的数据
	 */
	public static void decryptCaseCode(String input, String destPath) {
		// 当前解密生成的备选文件数
		int deCount = 0;
		// 获取出现频率最高的字符信息(出现次数越多越靠前)
		List<Entry<Character, Integer>> mapList = getMaxCountChar(input);
		for(Entry<Character, Integer> entry :mapList) {
			// 限制解密文件备选数
			if(deCount >= DE_MAX_FILE) {
				break;
			}
			
			// 输出前几位的统计信息
			System.out.println("字符'" + entry.getKey() + "'出现" + entry.getValue() + "次");
			
			++deCount;
			// 出现次数最高的字符跟MAGIC_CHAR的偏移量即为秘钥
			int key = entry.getKey() - MAGIC_CHAR;
			System.out.println("猜测key = " + key + ",解密生成第" + deCount + "个备选文件" + "\n");
			String decrypt = MyEncrypt.decrypt(input, key);
			String fileName = "de_" + deCount + destPath;
			string2File(decrypt, fileName);
		}
	}
	
	
	/**
	 * 统计String字符串中出现最多的字符
	 * 
	 * @param data 统计字符串数据
	 * @return List<Entry<Character, Integer>>
	 */
	public static List<Entry<Character, Integer>> getMaxCountChar(String data){
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char[] array = data.toCharArray();
		for(char c : array) {
			if(!map.containsKey(c)) {
				map.put(c, 1);
			}else {
				Integer count = map.get(c);
				map.put(c, count + 1);
			}
		}
		
		// 获取最大值
		int maxCount = 0;
		for(Entry<Character, Integer> entry : map.entrySet()) {
			// 不统计空格
			if(/*entry.getKey() != ' ' && */ entry.getValue() > maxCount) {
				maxCount = entry.getValue();
			}
		}
		
		// map转化成list便于排序
		List<Entry<Character, Integer>> mapList = new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());
		// 根据字符出现的次数排序
		Collections.sort(mapList, new Comparator<Entry<Character, Integer>>(){
			public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		
		return mapList;
	}
	
	
	/**
	 * 读取文件转化成字符串
	 * 
	 * @param path 读取文件路径
	 * @return 字符串
	 * @throws IOException 抛出IO异常
	 */
	public static String file2String(String path) throws IOException{
		FileReader reader = new FileReader(new File(path));
		char[] buffer = new char[1024];
		int len = -1;
		StringBuffer sb = new StringBuffer();
		while((len = reader.read(buffer)) != -1) {
			sb.append(buffer, 0, len);
		}
		return sb.toString();
	}
	
	
	/**
	 * 将String字符串写出到path目录下的文件
	 * 
	 * @param data 输入数据
	 * @param path 输入文件路径
	 */
	public static void string2File(String data, String path) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(new File(path));
			writer.write(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
