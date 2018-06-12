package com.basic.io.reader;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * String(byte[] bytes, String charsetName):通过制定字符集解码字节数组
 * byte[] getBytes(String charsetName):使用制定的字符集合把字符串解码为字节数组
 * 
 * 编码:把看得懂的变成看不懂的
 * Stirng -- byte[]
 * 
 * 解码:把看不懂的变成看的懂的
 * bute[] -- String
 * 
 * 举例:谍战片(发电报、接电报)
 * 码表:密码本    
 *       字符、数值
 * 要发送一段文字:
 *       今天晚上在老地方见
 *       发送端：今 -- 数值 -- 二进制 -- 发出去
 *       接收端：接收 -- 二进制 -- 十进制 -- 数值 -- 字符 -- 今
 *       
 *        今天晚上在老地方见
 * 编码问题简单，只要编码解码的格式是一致的。
 * @author robin
 *
 */
public class StringDemo01 {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "汉字";
		
		// String -- byte[]
		// [-26, -79, -119, -27, -83, -105]
//		byte[] bys = str.getBytes();
		//[-70, -70, -41, -42]
//		byte[] bys = str.getBytes("GBK");
		//[-26, -79, -119, -27, -83, -105]
		byte[] bys = str.getBytes("UTF-8");
		System.out.println(Arrays.toString(bys));
		
		// byte[] -- String
		// 汉字
//		String ss = new String(bys);
		// 姹夊瓧
//		String ss = new String(bys, "GBK");
		// 汉字
		String ss = new String(bys, "UTF-8");
		System.out.println("ss:" + ss);
	}

}
