package com.kaka.base.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaka.base.dto.JsonResponse;

/**
 * User: lzx, Date: 2016/1/2, Time: 19:57.
 */
@Controller
public class LoginController {

	@RequestMapping("/auth")
	@ResponseBody
	public JsonResponse auth(HttpSession httpSession) {
		httpSession.setAttribute("user", new Object());
		return JsonResponse.success("");
	}

}
