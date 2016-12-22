package com.wyb.nettyserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wyb.nettyserver.server.NettyServer;

public class NettyServerApp {

	private static Logger logger = LoggerFactory.getLogger(NettyServerApp.class);

	public static void main(String[] args) throws InterruptedException {
		logger.info("nettyserver is starting...");
		new NettyServer().bind(8090);
		logger.info("nettyserver is started...");
	}
}
