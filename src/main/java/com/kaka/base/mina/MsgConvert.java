package com.kaka.base.mina;

import java.util.Arrays;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import com.kaka.base.dto.MsgDto;
import com.kaka.base.exception.BusinessException;

public class MsgConvert {

	public static MsgDto decode(byte[] bytes) {
		MsgDto dto = new MsgDto();
		dto.setDeviceType(Hex.encodeHexString(new byte[] { bytes[2] }).toUpperCase());
		dto.setMasterId(Hex.encodeHexString(Arrays.copyOfRange(bytes, 3, 7)).toUpperCase());
		dto.setSlaveId(Hex.encodeHexString(Arrays.copyOfRange(bytes, 7, 11)).toUpperCase());
		dto.setServiceType(Hex.encodeHexString(new byte[] { bytes[11] }).toUpperCase());
		dto.setData(Hex.encodeHexString(Arrays.copyOfRange(bytes, 12, MsgConstant.MSG_LENGTH - 2)).toUpperCase());
		return dto;
	}

	public static byte[] encode(MsgDto dto) {
		StringBuffer sb = new StringBuffer(MsgConstant.MSG_LENGTH * 2);
		sb.append(MsgConstant.MSG_HEAD).append(MsgConstant.MSG_LENGTH_HEX);
		sb.append(dto.getDeviceType());
		sb.append(dto.getMasterId()).append(dto.getSlaveId());
		sb.append(dto.getServiceType());
		sb.append(dto.getData() == null ? MsgConstant.DATA_DEFAULT : dto.getData());
		byte[] msg = null;
		try {
			msg = Hex.decodeHex(sb.toString().toCharArray());
			byte check = 0;
			for (int i = 0; i < MsgConstant.MSG_LENGTH - 2; i++) {
				check ^= msg[i];
			}
			sb.append(Hex.encodeHexString(new byte[] { check }));
			sb.append(MsgConstant.MSG_END);
			return Hex.decodeHex(sb.toString().toCharArray());
		} catch (DecoderException e) {
			throw new BusinessException("MsgDto消息对象数据出错", e);
		}
	}
}
