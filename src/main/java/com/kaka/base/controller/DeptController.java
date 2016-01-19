package com.kaka.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaka.base.domain.Dept;
import com.kaka.base.dto.JsonResponse;
import com.kaka.base.service.DeptService;

@Controller
@RequestMapping("/dept")
public class DeptController {
	@Autowired
	private DeptService deptService;

	@RequestMapping("/create")
	@ResponseBody
	public JsonResponse create(HttpServletRequest request, Dept domain) {
		deptService.create(domain);
		return JsonResponse.success();
	}

	@RequestMapping("/all")
	@ResponseBody
	public JsonResponse queryAll() {
		return JsonResponse.success(deptService.queryAll());
	}

	@RequestMapping("/page")
	@ResponseBody
	public JsonResponse queryByPage(String name, int page, int rows) {
		return JsonResponse.success(deptService.queryByPage(name, page, rows));
	}

	@RequestMapping("/get")
	@ResponseBody
	public JsonResponse get(Long id) {
		return JsonResponse.success(deptService.get(id));
	}

	@RequestMapping("/delete")
	@ResponseBody
	public JsonResponse delete(Long id) {
		deptService.delete(id);
		return JsonResponse.success();
	}

	@RequestMapping("/update")
	@ResponseBody
	public JsonResponse update(Dept domain) {
		deptService.update(domain);
		return JsonResponse.success();
	}

	@RequestMapping("/all_tree")
	@ResponseBody
	public JsonResponse queryAllForTree() {
		return JsonResponse.success(deptService.queryAllForTree());
	}
}
