package com.cn.tran;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * 实现 I/O
 * Blocking networking without Netty
 * 
 * 1.绑定服务器到指定的端口。
 * 2.接受一个连接。
 * 3.创建一个新的线程来处理连接。
 * 4.将消息发送到连接的客户端。
 * 5.一旦消息被写入和刷新时就 关闭连接。
 * 6.启动线程。
 * @author robin
 *
 */
public class PlainOioServer {
	
	public void server(int port) throws IOException{
		final ServerSocket socket = new ServerSocket(port); // 1
		try {
			for(;;) {
				final Socket clientSocket = socket.accept(); // 2
				System.out.println("Accepted connection from " + clientSocket);
				
				new Thread(new Runnable() { // 3
					public void run() {
						OutputStream out;
						try {
							out = clientSocket.getOutputStream();
							out.write("HI!\r\n".getBytes(Charset.forName("UTF-8"))); // 4
							out.flush();
							clientSocket.close();
						}catch(IOException e) {
							e.printStackTrace();
							try {
								clientSocket.close(); // 5
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				}).start(); // 6
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
