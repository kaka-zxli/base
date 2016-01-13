package com.kaka.base.test;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class MinaClientHandlerTest extends IoHandlerAdapter {

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		System.out.println("客户端接收到的信息为：");
		byte[] bytes = (byte[]) message;
		for (byte b : bytes) {
			System.out.println(b);
		}
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		System.out.println("客户端发生异常..." + cause);
	}
}
