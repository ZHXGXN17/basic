package com.cn.api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private ServerSocket server;
	
	public Server() {
		try {
			server = new ServerSocket(8088);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void start() {
		while(true) {
			try {
				Socket socket = server.accept();
				ClientHandler handler = new ClientHandler(socket);
				Thread t = new Thread(handler);
				t.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
					
		}
	}
	
	
	private class ClientHandler implements Runnable{
		private Socket socket;
		
		private String host;
		
		public ClientHandler(Socket socket) {
			this.socket = socket;
		}

//		InetAddress address = socket.getInetAddress();
		
//		host = address.getHostAddress();
		public void run() {
			System.out.println("开始接受客户端连接=========");
			InputStreamReader isr = null;
			BufferedReader br = null;
			try {
				isr = new InputStreamReader(socket.getInputStream(), "UTF-8");
				br = new BufferedReader(isr);
				String message = null;
				byte[] by = new byte[4096];
				while((message = br.readLine()) != null) {
					message = br.readLine();
					System.out.println("message:" + message);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				System.out.println("断开连接");
				try {
					if(isr != null) {
						isr.close();
					}
					if(br != null) {
						br.close();
					}
					if(socket != null) {
						socket.close();
					}
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			Server server = new Server();
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static String reciveMessage(String ip, int port, byte[] b, byte[] ws, int readTimeOut, int connTimeout, String charsetName) {
		Socket socket = null;
		// 输出流
		DataOutputStream dos = null;
		// 输入流
		InputStream dis = null;
		try {
			socket = new Socket();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
