package com.kaka.base.mina;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ByteArrayEncoder extends ProtocolEncoderAdapter {

	private static final Logger logger = LoggerFactory.getLogger(ByteArrayEncoder.class);

	@Override
	public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {
		System.out.println("---------encode-------------");

		byte[] bytes = (byte[]) message;
		IoBuffer buffer = IoBuffer.allocate(bytes.length);
		buffer.setAutoExpand(true);
		buffer.put(bytes);
		buffer.flip();

		out.write(buffer);
		out.flush();

		buffer.free();
	}

	@Override
	public void dispose(IoSession session) throws Exception {
		logger.info("Dispose called,session is " + session);
	}
}
