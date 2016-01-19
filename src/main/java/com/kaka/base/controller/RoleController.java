package com.kaka.base.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaka.base.domain.Role;
import com.kaka.base.dto.JsonResponse;
import com.kaka.base.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@RequestMapping("/create")
	@ResponseBody
	public JsonResponse create(HttpServletRequest request, String name, String menuIds) {
		List<Long> menuIdList = new ArrayList<Long>();
		if (!StringUtils.isEmpty(menuIds)) {
			for (String s : menuIds.split(",")) {
				if (StringUtils.isNotEmpty(s.trim())) {
					menuIdList.add(Long.valueOf(s.trim()));
				}
			}
		}
		Role domain = new Role();
		domain.setName(name);
		roleService.create(domain, menuIdList);
		return JsonResponse.success();
	}

	@RequestMapping("/all")
	@ResponseBody
	public JsonResponse queryAll() {
		return JsonResponse.success(roleService.queryAll());
	}

	@RequestMapping("/page")
	@ResponseBody
	public JsonResponse queryByPage(String name, int page, int rows) {
		return JsonResponse.success(roleService.queryByPage(name, page, rows));
	}

	@RequestMapping("/get")
	@ResponseBody
	public JsonResponse get(Long id) {
		return JsonResponse.success(roleService.get(id));
	}

	@RequestMapping("/delete")
	@ResponseBody
	public JsonResponse delete(Long id) {
		roleService.delete(id);
		return JsonResponse.success();
	}

	@RequestMapping("/update")
	@ResponseBody
	public JsonResponse update(Long id, String name, String menuIds) {
		List<Long> menuIdList = new ArrayList<Long>();
		if (!StringUtils.isEmpty(menuIds)) {
			for (String s : menuIds.split(",")) {
				if (StringUtils.isNotEmpty(s.trim())) {
					menuIdList.add(Long.valueOf(s.trim()));
				}
			}
		}
		Role domain = new Role();
		domain.setId(id);
		domain.setName(name);
		roleService.update(domain, menuIdList);
		return JsonResponse.success();
	}
}
