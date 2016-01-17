package com.kaka.base.test;

import java.net.InetSocketAddress;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import com.kaka.base.mina.ByteArrayCoderFactory;

public class SocketClientTest {

	public static void main(String[] args) {
		System.out.println("begin");

		// 创建一个非阻塞的客户端程序
		IoConnector connector = new NioSocketConnector();
		connector.setHandler(new MinaClientHandlerTest());
		connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new ByteArrayCoderFactory()));
		try {
			// 120.24.242.251
			ConnectFuture future = connector.connect(new InetSocketAddress("127.0.0.1", 30996));// 创建连接
			future.awaitUninterruptibly();// 等待连接创建完成
			final IoSession session = future.getSession();// 获得session
			// 5a14a10000000100000000c00000000000002e0a
			for (int i = 0; i < 10; i++) {
				new Thread(new Runnable() {

					@Override
					public void run() {
						try {
							// 发送消息
							session.write(Hex.decodeHex("5a14a10000000100000000c00000000000002e0a".toCharArray()));
						} catch (DecoderException e) {
							e.printStackTrace();
						}
					}
				}).start();
			}
			session.getCloseFuture().awaitUninterruptibly();// 等待连接断开
			connector.dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("end");

	}

}
