package com.basic.io.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class pingIp {
	
	public static void main(String[] args) {
//		System.out.println(isOKPing("123.124.64.146"));
		pingIp();
	}

	public static boolean isOKPing(String ipAddr) {
		// 获取当前程序的运行进对象
		Runtime runtime = Runtime.getRuntime();
		// 声明处理类对象
	    Process process = null;
	    // 返回行信息
	    String line = null; 
	    // 输入流
	    InputStream is = null; 
	    // 字节流
	    InputStreamReader isr = null;
	    // 字节流
	    BufferedReader br = null;
	    // 结果
	    boolean res = false;
	    try {
	    	// PING
		    process = runtime.exec("ping " + ipAddr);
		    // 实例化输入流
		    is = process.getInputStream();
		    // 把输入流转换成字节流
		    isr = new InputStreamReader(is);
		    // 从字节中读取文本
		    br = new BufferedReader(isr);
		    while ((line = br.readLine()) != null) {
		        if (line.contains("TTL")) {
		            res = true;
		            break;
		        }
		    }
		    is.close();
		    isr.close();
		    br.close();
		    } catch (IOException e) {
		        runtime.exit(1);
		    }
		return res;
	}
	
	public static boolean pingIp() {
		Socket socket = new Socket();
		String host = "123.124.64.146";
		int port = 10086;
		SocketAddress add = new InetSocketAddress(host, port);
		try {
			socket.connect(add, 3000);
			System.out.println("连接成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
