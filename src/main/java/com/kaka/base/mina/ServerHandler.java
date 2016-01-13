package com.kaka.base.mina;

import org.apache.commons.codec.binary.Hex;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerHandler extends IoHandlerAdapter {

	private static final Logger logger = LoggerFactory.getLogger(ServerHandler.class);

	private final static String MSG_HEAD = "5A";
	private final static byte MSG_LENGTH = 20;

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		logger.info("连接打开：" + session.getRemoteAddress());
	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		logger.info("服务端收到信息-------object------" + message);

		String sb = "";
		byte[] bytes = (byte[]) message;
		for (byte b : bytes) {
			sb += b + " ";
		}
		logger.info("服务端收到信息-------byte------" + sb);
		logger.info("服务端收到信息--------hex-----" + Hex.encodeHexString(bytes));

		// 回写消息
		session.write(message);

		if (bytes.length < 2) {
			logger.warn("报文长度错误, length = " + bytes.length);
			return;
		}
		String head = Hex.encodeHexString(new byte[] { bytes[0] });
		if (!MSG_HEAD.equalsIgnoreCase(head)) {
			logger.warn("报文头错误, head = " + head);
			return;
		}
		byte length = bytes[1];
		if (length != bytes.length && length != MSG_LENGTH) {
			logger.warn("报文长度错误, 报文字段说明 的length = " + length + ", 实际报文length = " + bytes.length);
			return;
		}

		// 获取客户端发过来的key
		// String key = message.toString();
		// System.out.println("message :" + message.toString());
		// String carPark_id = key.substring(key.indexOf("=") + 1);
		// System.out.println("carPark_id :" + carPark_id);

	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		logger.info("--服务端发消息到客户端--hex------" + Hex.encodeHexString((byte[]) message));
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		logger.info("远程session关闭了一个..." + session.getRemoteAddress().toString());
	}

}
