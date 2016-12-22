package com.wyb.nettyserver.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.router.Routed;

public class HttpNettyHandler extends SimpleChannelInboundHandler<Routed> {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	protected void messageReceived(ChannelHandlerContext ctx, Routed msg) throws Exception {
		logger.info("this is test Handler.");
		logger.debug("body={}", msg.toString());
		ctx.write(Unpooled.copiedBuffer(msg.toString().getBytes()));
	}

}
