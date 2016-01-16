package com.kaka.base.test;

import java.net.InetSocketAddress;

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
		IoSession session = null;
		try {
			ConnectFuture future = connector.connect(new InetSocketAddress("120.24.242.251", 30996));// 创建连接
			future.awaitUninterruptibly();// 等待连接创建完成
			session = future.getSession();// 获得session
			session.write(Hex.decodeHex("5A14A10000001100000022660000000000004455".toCharArray()));// 发送消息
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        session.getCloseFuture().awaitUninterruptibly();// 等待连接断开
		connector.dispose();

		System.out.println("end");

	}

}
