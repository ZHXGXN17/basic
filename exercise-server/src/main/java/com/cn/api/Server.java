package com.cn.api;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
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
			OutputStream os = null;
			BufferedReader br = null;
			PrintWriter pw = null;
			try {
				isr = new InputStreamReader(socket.getInputStream());
				br = new BufferedReader(isr);
				String message = null;
				while((message = br.readLine()) != null) {
//					message = br.readLine();
					System.out.println("message:" + message);
				}
				// 关闭输入流
				socket.shutdownInput();
				// 获取输出流，响应客户端的请求
				os = socket.getOutputStream();
				os.write(read("sms_input.xml"));
				os.flush();
//				pw = new PrintWriter(os);
//				pw.write("报文已收到.......");
//				pw.flush();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				System.out.println("断开连接");
				try {
					if(isr != null) {
						isr.close();
					}
					if(os != null) {
						os.close();
					}
					if(br != null) {
						br.close();
					}
					if(pw != null) {
						pw.close();
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
	
	
	/**
	 * 读取xml报文文件，分为GBK、UTF-8两种格式
	 * @param fileName
	 * @return
	 */
	public static byte[] read(String fileName) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileName));
			StringBuilder builder = new StringBuilder();
			String line = null;
			while((line = br.readLine()) != null) {
				builder.append(line);
			}
			
			// 报文长度,不够8位，左补0
			String str = null;
			if(builder.indexOf("GBK") != -1) {
				str = String.format("%08d", builder.toString().getBytes("GBK").length);
			}else if(builder.indexOf("UTF-8") != -1) {
				str = String.format("%08d", builder.toString().getBytes("UTF-8").length);
			}
			// 报文长度
			builder.insert(0, str);
			
			byte[] bys = builder.toString().getBytes("GBK");
			return bys;
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		try {
			Server server = new Server();
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
