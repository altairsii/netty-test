package com.wyb.nettyclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wyb.nettyclient.server.NettyClient;

public class NettyClientApp {

	private static Logger logger = LoggerFactory.getLogger(NettyClientApp.class);

	public static void main(String[] args) throws InterruptedException {
		logger.info("nettyserver is starting...");
		new NettyClient().connect(8090, "127.0.0.1");
		logger.info("nettyserver is started...");
	}
}
