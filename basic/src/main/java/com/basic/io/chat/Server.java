package com.basic.io.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 聊天室服务端
 * @author Administrator
 *
 */
public class Server {
	/*
	 * java.net.ServerSocket
	 * 运行在服务端的ServerSocket负责申请
	 * 服务端口，客户端就是通过这个端口与
	 * 这边服务端应用程序建立连接的。
	 * ServerSocket的另一个职责就是监听该
	 * 端口，一旦一个客户端连接，这边就会
	 * 自动创建一个Socket，通过这个Socket就
	 * 可以与刚刚连接的客户端通讯了。
	 */
	private ServerSocket server;
	
	public Server(){
		try {
			/*
			 * 初始化ServerSocket时要指定
			 * 服务端口，客户端通过该端口
			 * 进行连接，该端口号不能与操作
			 * 系统其它应用程序申请的重复，
			 * 否则会抛出异常
			 */
			server = new ServerSocket(8088);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void start(){
		try {
			/*
			 * 该方法是一个阻塞方法，用于一直
			 * 监听服务端口(8088),直到一个客户
			 * 端连接，然后就创建一个与该客户端
			 * 通讯的Socket
			 */
			while(true){
				System.out.println("等待客户端连接...");
				Socket socket = server.accept();
				System.out.println("一个客户端连接了!");
				//启动一个线程来处理该客户端的交互
				ClientHandler handler
					= new ClientHandler(socket);
				Thread t = new Thread(handler);
				t.start();
			}
		} catch (Exception e) {
			
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
	
	/**
	 * 该线程负责与一个客户端进行交互
	 * @author Administrator
	 *
	 */
	private class ClientHandler 
					implements Runnable{
		private Socket socket;
		//客户端的地址信息
		private String host;
		
		public ClientHandler(Socket socket){
			this.socket = socket;
			/*
			 * 获取远程计算机的地址信息
			 */
			InetAddress address
				= socket.getInetAddress();
			//获取客户端ip地址的字符串格式
			host = address.getHostAddress();
		}
		public void run(){
			try {
				System.out.println(host+"上线了!");
				/*
				 * Socket提供的方法:
				 * InputStream getInputStream()
				 * 该方法获取的输入流是用来读取远端计算机
				 * 发送过来的数据的。
				 */
				InputStream in 
					= socket.getInputStream();
				
				InputStreamReader isr
					= new InputStreamReader(in,"UTF-8");
				
				BufferedReader br
					= new BufferedReader(isr);
				String message = null;
				while((message = br.readLine())!=null){
					/*
					 * 当客户端断开连接后，由于客户端的
					 * 操作系统不同，服务端这里br.readLine
					 * 方法的执行结果也不同:
					 * 当windows客户端断开连接后:br.readLine
					 * 方法会直接抛出异常
					 * 当linux客户端断开连接后:br.readLine
					 * 方法会返回null。
					 */
//					message = br.readLine();
					System.out.println(host+"说:"+message);
				}
			} catch (Exception e) {
				
			} finally{
				//处理客户端断开连接后的操作			
				System.out.println(host+"下线了...");
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}










