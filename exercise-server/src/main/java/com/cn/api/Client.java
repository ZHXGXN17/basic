package com.cn.api;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class Client {
	
	private Socket socket;
	
	public Client() {
		try {
			System.out.println("正在连接服务端......");
			socket = new Socket("127.0.0.1", 8000);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * socket连接服务端
	 * @param bys
	 * @throws Exception 
	 */
	public void start(byte[] bys) throws Exception{
		OutputStream out = null;
		InputStream is = null;
		BufferedReader br = null;
		try {
			out = socket.getOutputStream();
			out.write(bys);
			out.flush();
			// 关闭输出流
//			socket.shutdownOutput();
			
			// 获取输入流
			is = socket.getInputStream();
			byte[] bytes = new byte[309];
			int i = 0;
			while((i = is.read(bys)) != -1) {
				System.out.println(new String(bys, 0, i));
			}
			
//			br = new BufferedReader(new InputStreamReader(is));
//			String info = null;
//			while((info=br.readLine()) != null){
//				System.out.println(info);
//			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(out != null) {
					out.close();
				}
				if(is != null) {
					is.close();
				}
				if(br != null) {
					br.close();
				}
			}catch(IOException e1) {
				e1.printStackTrace();
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
			builder.insert(0, str);
			
			byte[] bys = null;
			if(builder.indexOf("GBK") != -1) {
				bys = builder.toString().getBytes("GBK");
			}else if(builder.indexOf("UTF-8") != -1) {
				bys = builder.toString().getBytes("UTF-8");
			}
			System.out.println(new String(bys));
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
	
	
	// gbk读
	public static byte[] readGbk(String fileName) {
		InputStreamReader isr = null;
		try {
			isr = new InputStreamReader(new FileInputStream(fileName), "GBK");
			StringBuilder builder = new StringBuilder();
			char[] chs = new char[1024];
			int len = 0;
			while((len = isr.read(chs)) != -1) {
				builder.append(new String(chs, 0, len));
			}
			
			String str = String.format("%08d", builder.toString().getBytes().length);
			builder.insert(0, str);
			
			byte[] bys = builder.toString().getBytes();
			System.out.println(new String(bys));
			return bys;
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(isr != null) {
				try {
					isr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}
	
	
	public static void main(String[] args) {
		try {
			Client client = new Client();
			client.start(read("sms_out.xml"));
//			client.start(readGbk("sms_out.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
