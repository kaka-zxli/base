package com.kaka.base.mina;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

public class ByteArrayCoderFactory implements ProtocolCodecFactory {

	private final ByteArrayEncoder encoder;
	private final ByteArrayDecoder decoder;

	public ByteArrayCoderFactory() {
		this.encoder = new ByteArrayEncoder();
		this.decoder = new ByteArrayDecoder();
	}

	@Override
	public ProtocolDecoder getDecoder(IoSession arg0) throws Exception {
		return decoder;
	}

	@Override
	public ProtocolEncoder getEncoder(IoSession arg0) throws Exception {
		return encoder;
	}
}
