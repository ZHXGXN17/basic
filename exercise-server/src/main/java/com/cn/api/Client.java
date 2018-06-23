package com.cn.api;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Map;

public class Client {
	
	private Socket socket;
	
	public Client() {
		try {
			socket = new Socket("127.0.0.1", 8088);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void start(){
		try {
			OutputStream out = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");
			PrintWriter pw = new PrintWriter(osw,true);
//			String message = null;
			StringBuilder sb = new StringBuilder("00000000<?xml version=\"1.0\" encoding=\"GBK\"?>");
	        sb.append("<sms>\r\n" + 
	        		"  <head>\r\n" + 
	        		"    <transcode>1013</transcode>\r\n" + 
	        		"    <seqno>10000001</seqno>\r\n" + 
	        		"  </head>\r\n" + 
	        		"  <msg>\r\n" + 
	        		"     <channel> 1234</channel>\r\n" + 
	        		"     <mobile> 13712345678 </mobile>\r\n" + 
	        		"     <content> 测试 </content>\r\n" + 
	        		"  </msg>\r\n" + 
	        		"</sms>\r\n" + 
	        		"");
	        sb.toString().getBytes();
	        
	        String message = sb.toString();
	        byte[] bys = message.getBytes("gbk");
			while(true){
				pw.println(bys);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception{
		String str = "00000000<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n" + 
				"<sms>\r\n" + 
				"  <head>\r\n" + 
				"    <transcode>1013</transcode>\r\n" + 
				"    <seqno>10000001</seqno>\r\n" + 
				"  </head>\r\n" + 
				"  <msg>\r\n" + 
				"     <channel> 1234</channel>\r\n" + 
				"     <mobile> 13712345678 </mobile>\r\n" + 
				"     <content> 测试 </content>\r\n" + 
				"  </msg>\r\n" + 
				"</ sms >\r\n" + 
				"";
		Socket client = new Socket("127.0.0.1", 8088);
        OutputStream out = client.getOutputStream();
        
        byte[] bys = str.getBytes("gbk");
        out.write(bys.length);
        out.write(bys);
        out.close();
        client.close();
		
//		try {
//			Client client = new Client();
//			client.start();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
	
	private static byte[] formatMessage(Map<String, Object> map) throws Exception {
        StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"GBK\"?>");
        sb.append("<sms>\r\n" + 
        		"  <head>\r\n" + 
        		"    <transcode>1013</transcode>\r\n" + 
        		"    <seqno>10000001</seqno>\r\n" + 
        		"  </head>\r\n" + 
        		"  <msg>\r\n" + 
        		"     <channel> 1234</channel>\r\n" + 
        		"     <mobile> 13712345678 </mobile>\r\n" + 
        		"     <content> 测试 </content>\r\n" + 
        		"  </msg>\r\n" + 
        		"</sms>\r\n" + 
        		"");
        sb.toString().getBytes();
        
        String message = sb.toString();
        byte[] bys = message.getBytes("gbk");
        
//        String message = sb.toString();
        return bys;
    }
	
	
	
	
	
	public static String sendMessage(String ip, int port, byte[] b, byte[] ws, int readTimeOut, int connTimeout, String charsetName) {
		Socket socket = null;
		// 输出流
		DataOutputStream dos = null;
		// 输入流
		InputStream dis = null;
		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress(ip, port), connTimeout);
			socket.setSoTimeout(readTimeOut);
			dos = new DataOutputStream(socket.getOutputStream());
			
			dos.write(b);
			dos.write(ws);
			dos.flush();
			dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			
			byte[] bys = new byte[1024];
			int len = 0;
			String resMsg = null;
			while((len = dis.read(bys)) != -1) {
				resMsg = new String(bys, 0, len, charsetName);
			}
			
			return resMsg;
		}catch(Exception e) {
			try {
				if(dis != null) {
					dis.close();
				}
				if(dos != null) {
					dos.close();
				}
				if(socket != null) {
					socket.close();
				}
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return null;
	}

}
