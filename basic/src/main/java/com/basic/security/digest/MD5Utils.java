package com.basic.security.digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密工具类.
 *
 * @ClassName:  MD5Utils
 * @author: wangyf
 * @date:   2018-7-11 8:51:31
 * @since:  v1.0
 */
public class MD5Utils {
	
	/**
	 * MD5加密.
	 *
	 * @param pwd the pwd
	 * @return the string
	 */
	public static String encode(String pwd) {
		// MessageDigest
		MessageDigest digester;
		try {
			digester = MessageDigest.getInstance("MD5");
			// 加密，将要加密的字符串转换成字节数组
			byte[] digest = digester.digest(pwd.getBytes());
			
			StringBuffer buffer = new StringBuffer();
			// 0000 - 0101
			// 1111 - 1111
			// 0000 - 0101
			for(byte b : digest) {
				// 0xff 表示低8位
				int number = b & 0xff;
				// int 32位，一个int是4个字节，一个字节8位
				// 任何一个值&0等于0
				// & 1 = 1
				String hexString = Integer.toHexString(number);
				if(hexString.length() == 1) {
					buffer.append("0" + hexString);
				}else {
					buffer.append(hexString);
				}
			}
			
			System.out.println("密码长度---" + buffer.toString().length());
			System.out.println("密码---" + buffer.toString());
			return buffer.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}

}
