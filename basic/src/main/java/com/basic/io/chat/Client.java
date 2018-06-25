package com.basic.io.chat;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 聊天室客户端
 * @author Administrator
 *
 */
public class Client {
	/*
	 * 套接字
	 * 封装着TCP协议的通讯
	 * 使用它可以进行基于TCP协议的网络通讯
	 */
	private Socket socket;
	/**
	 * 构造方法，用来初始化客户端
	 */
	public Client(){
		try {
			/*
			 * 实例化Socket的时候需要传入
			 * 两个参数:
			 * 1:远端计算机的IP地址
			 * 2:远端计算机的端口
			 * 通过IP地址可以找到服务端的
			 * 计算机，通过端口可以找到运行
			 * 在该机器上的服务端应用程序。
			 * 
			 * 实例化Socket的过程就是连接
			 * 远端计算机的过程，若远端计算机
			 * 没有响应，会抛出异常导致实例化
			 * 失败。
			 */
			System.out.println("正在连接服务端...");
			socket = new Socket(
				"localhost",8088	
			);
			System.out.println("连接服务端完毕!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 客户端开始工作的方法
	 */
	public void start(){
		try {
			Scanner scanner 
				= new Scanner(System.in);
			/*
			 * Socket提供了方法:
			 * OutputStream getOutputStream()
			 * 获取一个字节输出流，通过该流
			 * 写出的字节会被发送到远端计算机
			 */
			OutputStream out
				= socket.getOutputStream();
			OutputStreamWriter osw
				= new OutputStreamWriter(
					out,"UTF-8"	
				);
			PrintWriter pw
				= new PrintWriter(osw,true);
			
			String message = null;
			while(true){
				message = scanner.nextLine();
				pw.println(message);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			Client client = new Client();
			client.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}





