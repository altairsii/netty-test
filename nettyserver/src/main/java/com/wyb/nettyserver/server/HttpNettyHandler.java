package com.wyb.nettyserver.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.router.Routed;

public class HttpNettyHandler extends SimpleChannelInboundHandler<Routed> {

	@Override
	protected void messageReceived(ChannelHandlerContext ctx, Routed msg) throws Exception {
		// TODO Auto-generated method stub

	}

}
