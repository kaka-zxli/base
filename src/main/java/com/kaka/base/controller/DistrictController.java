package com.kaka.base.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaka.base.domain.District;
import com.kaka.base.domain.DistrictArea;
import com.kaka.base.dto.JsonResponse;
import com.kaka.base.service.DistrictService;

@Controller
@RequestMapping("/district")
public class DistrictController {

	@Autowired
	private DistrictService districtService;

	@RequestMapping("/create")
	@ResponseBody
	public JsonResponse create(HttpServletRequest request, String name, String areas)
			throws JsonParseException, JsonMappingException, IOException {
		District domain = new District();
		domain.setName(name);

		ObjectMapper mapper = new ObjectMapper();
		DistrictArea[] a = mapper.readValue(areas, DistrictArea[].class);

		districtService.create(domain, Arrays.asList(a));
		return JsonResponse.success();
	}

	@RequestMapping("/all")
	@ResponseBody
	public JsonResponse queryAll() {
		return JsonResponse.success(districtService.queryAll());
	}

	@RequestMapping("/page")
	@ResponseBody
	public JsonResponse queryByPage(String name, int page, int rows) {
		return JsonResponse.success(districtService.queryByPage(name, page, rows));
	}

	@RequestMapping("/get")
	@ResponseBody
	public JsonResponse get(Long id) {
		return JsonResponse.success(districtService.get(id));
	}

	@RequestMapping("/delete")
	@ResponseBody
	public JsonResponse delete(Long id) {
		districtService.delete(id);
		return JsonResponse.success();
	}

	@RequestMapping("/update")
	@ResponseBody
	public JsonResponse update(Long id, String name, String areas)
			throws JsonParseException, JsonMappingException, IOException {
		District domain = new District();
		domain.setId(id);
		domain.setName(name);

		ObjectMapper mapper = new ObjectMapper();
		DistrictArea[] a = mapper.readValue(areas, DistrictArea[].class);
		districtService.update(domain, Arrays.asList(a));
		return JsonResponse.success();
	}
}
