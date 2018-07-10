package com.basic.encry;

/**
 * 凯撒密码加密、解密.
 *
 * @ClassName:  MyEncrypt
 * @author: wangyf
 * @date:   2018-7-10 9:15:03
 * @since:  v5.0
 */
public class MyEncrypt {
	
	/**
	 * 按照秘钥进行加密
	 * 
	 * @param input 数据源(需要加密的数据)
	 * @param key 秘钥，即偏移量
	 * @return 返回加密后的数据
	 */
	public static String encrypt(String input, int key) {
		// 得到字符串中的每一个字符
		char[] array = input.toCharArray();
		
		// 遍历
		for(int i = 0;i < array.length;++i) {
			// 字符转化成ASCII码
			int ascii = array[i];
			// 字符偏移，例如a->b
			ascii = ascii + key;
			// ASCII码转换成char
			char newChar = (char)ascii;
			// 替换原有字符
			array[i] = newChar;
			
			// 以上4行代码可以简写为一行
//			array[i] = (char)(array[i] + key);
		}
		return new String(array);
	}
	
	
	/**
	 * Decrypt.
	 *
	 * @param input the input
	 * @param key the key
	 * @return the string
	 */
	public static String decrypt(String input, int key) {
		// 得到字符串里的每一个字符
		char[] array = input.toCharArray();
		for(int i = 0;i < array.length;++i) {
			// 字符转换成ASCII码
			int ascii = array[i];
			// 恢复字符偏移，例如b->a
			ascii = ascii - key;
			// ASCII码值转换成char
			char newChar = (char)ascii;
			// 替换原有字符
			array[i] = newChar;
			
			// 以上可合并为一行
//			array[i] = (char)(array[i] - key);
		}
		return new String(array);
	}
	

}
