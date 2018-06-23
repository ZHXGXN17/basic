package com.cn;

import com.cn.util.MarshallingCodeCFactory;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.ReadTimeoutHandler;

public class DiscardClient {
	
	private EventLoopGroup workerGroup;

    private Bootstrap bootstrap;

    private ChannelFuture future;
	
	private static class SingleHodler{
		static final DiscardClient client = new DiscardClient();
	}
	
	public static DiscardClient getInstance() {
		return SingleHodler.client;
	}
	
	private DiscardClient() {
		workerGroup = new NioEventLoopGroup();
		bootstrap = new Bootstrap();
		bootstrap.group(workerGroup)
		         .channel(NioSocketChannel.class)
		         .handler(new ChannelInitializer<SocketChannel>() {
					@Override
					protected void initChannel(SocketChannel socketChannel) throws Exception {
						socketChannel.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingEncoder());
						socketChannel.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingDecoder());
						//5秒后未与服务器通信，则断开连接。
						socketChannel.pipeline().addLast(new ReadTimeoutHandler(5));
						socketChannel.pipeline().addLast(new DiscardClientHandler());
					}
		         });
//		ChannelFuture future = bootstrap.connect("127.0.0.1", 8379).sync();
//		future.channel().writeAndFlush(Unpooled.copiedBuffer("777".getBytes()));
//		future.channel().closeFuture().sync();
//		workerGroup.shutdownGracefully();
	}
	
	public void connect() {
        try {
            future =bootstrap.connect("127.0.0.1", 8379).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
	public ChannelFuture getFuture() {
        if(future == null ||!future.channel().isActive()) {
            this.connect();
        }
        return future;
    }
	
	 public static void main(String[] args)throws InterruptedException {
		 final DiscardClient client = getInstance();
		 ChannelFuture future = client.getFuture();
		 for(int i = 1;i <= 3;i++) {
//			 Message message = new Message(i, "pro" + i, "数据信息" + i);
//	         future.channel().writeAndFlush(message);
	         Thread.sleep(4000);  //休眠4秒后再发送数据
		 }
	     future.channel().closeFuture().sync();
	     new Thread() {
	    	 public void run() {
	    	 try {
	    		 System.out.println("子线程开始......");
	    		 ChannelFuture future = client.getFuture();
//	    		 Message msg = new Message(4, "pro" + 4, "数据信息" + 4);
//	    		 future.channel().writeAndFlush(msg);
	    		 future.channel().closeFuture().sync();
	    	 }catch(Exception e) {
	    		 e.printStackTrace();
	    	 }
	    	 }
	     }.start();
	 }
}
