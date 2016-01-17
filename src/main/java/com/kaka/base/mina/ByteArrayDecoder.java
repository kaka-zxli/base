package com.kaka.base.mina;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoderAdapter;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

public class ByteArrayDecoder extends ProtocolDecoderAdapter {

	@Override
	public void decode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
		int limit = in.limit();
		int count = limit / MsgConstant.MSG_LENGTH;
		for (int i = 0; i < count; i++) {
			byte[] bytes = new byte[MsgConstant.MSG_LENGTH];
			in.get(bytes);
			out.write(bytes);
		}
		if (limit % MsgConstant.MSG_LENGTH != 0) {
			byte[] bytes = new byte[limit % MsgConstant.MSG_LENGTH];
			in.get(bytes);
			out.write(bytes);
		}
	}
}
