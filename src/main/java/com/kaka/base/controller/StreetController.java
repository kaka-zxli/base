package com.kaka.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaka.base.domain.Street;
import com.kaka.base.dto.JsonResponse;
import com.kaka.base.service.StreetService;

@Controller
@RequestMapping("/street")
public class StreetController {

	@Autowired
	private StreetService streetService;

	@RequestMapping("/create")
	@ResponseBody
	public JsonResponse create(HttpServletRequest request, Street street) {
		streetService.create(street);
		return JsonResponse.success();
	}

	@RequestMapping("/all")
	@ResponseBody
	public JsonResponse queryAll() {
		return JsonResponse.success(streetService.queryAll());
	}

	@RequestMapping("/page")
	@ResponseBody
	public JsonResponse queryByPage(String name, int page, int rows) {
		return JsonResponse.success(streetService.queryByPage(name, page, rows));
	}

	@RequestMapping("/get")
	@ResponseBody
	public JsonResponse get(Long id) {
		return JsonResponse.success(streetService.get(id));
	}

	@RequestMapping("/delete")
	@ResponseBody
	public JsonResponse delete(Long id) {
		streetService.delete(id);
		return JsonResponse.success();
	}

	@RequestMapping("/update")
	@ResponseBody
	public JsonResponse update(Street street) {
		streetService.update(street);
		return JsonResponse.success();
	}
}
