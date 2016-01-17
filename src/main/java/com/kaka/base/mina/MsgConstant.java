package com.kaka.base.mina;

import org.apache.commons.codec.binary.Hex;

public interface MsgConstant {

	String MSG_HEAD = "5A";
	String MSG_END = "0A";
	byte MSG_LENGTH = 20;
	String MSG_LENGTH_HEX = Hex.encodeHexString(new byte[] { MSG_LENGTH });
	String DATA_DEFAULT = "000000000000";

}
