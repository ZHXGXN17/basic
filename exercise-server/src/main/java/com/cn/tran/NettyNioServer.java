package com.cn.tran;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Netty NIO
 * Asynchronous networking with Netty
 * 
 * 1.创建一个 ServerBootstrap
 * 2.使用 OioEventLoopGroup 允许阻塞模式（Old-IO）
 * 3.指定 ChannelInitializer 将给每个接受的连接调用
 * 4.添加的 ChannelInboundHandlerAdapter() 接收事件并进行处理
 * 5.写信息到客户端，并添加 ChannelFutureListener 当一旦消息写入就关闭连接
 * 6.绑定服务器来接受连接
 * 7.释放所有资源
 * @author robin
 *
 */
public class NettyNioServer {
	
	public void server(int port) throws Exception{
		final ByteBuf buf = Unpooled.unreleasableBuffer(
				Unpooled.copiedBuffer("Hi!\r\n", Charset.forName("UTF-8")));
		NioEventLoopGroup group = new NioEventLoopGroup();
		try {
			ServerBootstrap bootstrap = new ServerBootstrap(); // 1
			bootstrap.group(new NioEventLoopGroup(), new NioEventLoopGroup())
			         .channel(NioServerSocketChannel.class)
			         .localAddress(new InetSocketAddress(port))
			         .childHandler(new ChannelInitializer<SocketChannel>() { // 3
						@Override
						protected void initChannel(SocketChannel socketChannel) throws Exception {
							socketChannel.pipeline().addLast(new ChannelInboundHandlerAdapter() { // 4
								public void channelActive(ChannelHandlerContext ctx) throws Exception{
									ctx.writeAndFlush(buf.duplicate()).addListener(ChannelFutureListener.CLOSE); // 5
								}
							});
						}
			         });
			ChannelFuture future = bootstrap.bind().sync(); // 6
			future.channel().closeFuture().sync();
		}finally {
			group.shutdownGracefully().sync(); // 7
		}
	}
	

}
