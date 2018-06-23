package com.cn;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 处理服务器端通道
 * @author robin
 *
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter{
	
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{
		ByteBuf buf = (ByteBuf)msg;
		byte[] data = new byte[buf.readableBytes()];
		buf.readBytes(data);
		String request = new String(data, "utf-8");
		System.out.println("DiscardServer:" + request);
		// 写给客户端
		String response = "我是反馈的信息";
		ctx.writeAndFlush(Unpooled.copiedBuffer("888".getBytes()));
//		ctx.writeAndFlush(ChannelFutureListener.CLOSE);
	}
	
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception{
		cause.printStackTrace();
		ctx.close();
	}
}
