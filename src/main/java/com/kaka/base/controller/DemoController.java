package com.kaka.base.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaka.base.dto.JsonResponse;

/**
 * Created by lzx on 2014/9/17.
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

	private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

	@RequestMapping("/greeting")
	@ResponseBody
	public JsonResponse greeting(String name) {
		System.out.println("ccc");
		logger.warn("warn------");
		logger.error("error------");
		logger.info("info------");
		logger.debug("debug------");
		return JsonResponse.success();
	}
}
