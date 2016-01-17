package com.kaka.base.mina;

import org.apache.commons.codec.binary.Hex;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.kaka.base.dto.MsgDto;
import com.kaka.base.service.MsgService;

public class ServerHandler extends IoHandlerAdapter {

	private static final Logger logger = LoggerFactory.getLogger(ServerHandler.class);

	@Autowired
	private MsgService msgService;

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		logger.info("连接打开：" + session.getRemoteAddress());
	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		byte[] bytes = (byte[]) message;

		logger.info("服务端收到信息--------hex-----" + Hex.encodeHexString(bytes));

		if (bytes.length < 2) {
			logger.warn("报文长度错误, length = " + bytes.length);
			return;
		}
		String head = Hex.encodeHexString(new byte[] { bytes[0] });
		if (!MsgConstant.MSG_HEAD.equalsIgnoreCase(head)) {
			logger.warn("报文头错误, head = " + head);
			return;
		}
		byte length = bytes[1];
		if (length != bytes.length || length != MsgConstant.MSG_LENGTH) {
			logger.warn("报文长度错误, 报文字段说明 的length = " + length + ", 实际报文length = " + bytes.length);
			return;
		}
		String end = Hex.encodeHexString(new byte[] { bytes[bytes.length - 1] });
		if (!MsgConstant.MSG_END.equalsIgnoreCase(end)) {
			logger.warn("报文结束符错误, end = " + end);
			return;
		}
		byte check = 0;
		for (int i = 0; i < MsgConstant.MSG_LENGTH - 2; i++) {
			check ^= bytes[i];
		}
		if (check != bytes[MsgConstant.MSG_LENGTH - 2]) {
			logger.warn("报文异或校验错误, 报文check = " + Hex.encodeHexString(new byte[] { bytes[MsgConstant.MSG_LENGTH - 2] })
					+ ", 服务器算出的check=" + Hex.encodeHexString(new byte[] { check }));
			return;
		}

		MsgDto dto = MsgConvert.decode(bytes);
		msgService.receive(dto);

		SessionMap.put(dto.getMasterId(), session);

		// 回写消息
		session.write(message);
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
