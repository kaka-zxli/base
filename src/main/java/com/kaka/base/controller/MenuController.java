package com.kaka.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaka.base.dto.JsonResponse;
import com.kaka.base.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;

	@RequestMapping("/user")
	@ResponseBody
	public JsonResponse queryByUser() {
		return JsonResponse.success(menuService.queryAllForTree());
	}

	@RequestMapping("/all_tree")
	@ResponseBody
	public JsonResponse queryAllForTree() {
		return JsonResponse.success(menuService.queryAllForTree());
	}
}
