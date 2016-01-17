package com.kaka.base.service;

import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.kaka.base.dto.MsgDto;
import com.kaka.base.exception.BusinessException;
import com.kaka.base.mina.MsgConvert;
import com.kaka.base.mina.SessionMap;

@Service
public class MsgService {

	private static final Logger logger = LoggerFactory.getLogger(MsgService.class);

	public void receive(MsgDto dto) {
		logger.info("MsgService收到终端的消息" + dto.toString());
	}

	public void send(MsgDto dto) {
		logger.info("MsgService发送消息给终端" + dto.toString());

		IoSession session = SessionMap.get(dto.getMasterId());
		if (session == null) {
			throw new BusinessException("设备没有连接");
		}

		session.write(MsgConvert.encode(dto));
	}

}
