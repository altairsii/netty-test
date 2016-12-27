package com.wyb.nettyclient.server;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class NettyClientHandler extends ChannelHandlerAdapter {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private byte[] req;

	public NettyClientHandler() {
		req = ("this is a test." + new Random(100).nextInt() + System.getProperty("line.separator")).getBytes();
	}

	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		for (int i = 0; i < 100000; i++) {
			ByteBuf firstMessage;
			firstMessage = Unpooled.buffer(req.length);
			firstMessage.writeBytes(req);
			ctx.writeAndFlush(firstMessage);
		}
	}

	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf buf = (ByteBuf) msg;
		byte[] req = new byte[buf.readableBytes()];
		buf.readBytes(req);
		String body = new String(req, "UTF-8");
		logger.debug("body={}", body);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		logger.warn("cause is ", cause);
		ctx.close();
	}
}
