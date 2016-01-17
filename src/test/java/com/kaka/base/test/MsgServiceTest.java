package com.kaka.base.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kaka.base.dto.MsgDto;
import com.kaka.base.service.MsgService;

@ContextConfiguration(locations = { "classpath:application.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class MsgServiceTest {

	@Autowired
	private MsgService msgService;

	@Test
	public void testSend() {
		MsgDto dto = new MsgDto();
		dto.setDeviceType("A1");
		dto.setMasterId("00000001");
		dto.setSlaveId("00000000");
		dto.setServiceType("c0");
		dto.setData(null);
		msgService.send(dto);
	}
}
