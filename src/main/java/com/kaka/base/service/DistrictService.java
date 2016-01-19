package com.kaka.base.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaka.base.dao.IDistrictDao;
import com.kaka.base.domain.District;
import com.kaka.base.domain.DistrictArea;
import com.kaka.base.dto.PageDto;

@Service
public class DistrictService {
	@Autowired
	private IDistrictDao districtDao;
	@Autowired
	private DistrictAreaService districtAreaService;

	@Transactional
	public void create(District domain, List<DistrictArea> areaList) {
		districtDao.create(domain);

		for (DistrictArea area : areaList) {
			area.setDistrictId(domain.getId());
		}
		districtAreaService.createByBatch(areaList);
	}

	public List<District> queryAll() {
		return districtDao.queryAll();
	}

	@Transactional
	public void update(District domain, List<DistrictArea> areaList) {
		districtDao.update(domain);

		districtAreaService.deleteByDistrict(domain.getId());

		for (DistrictArea area : areaList) {
			area.setDistrictId(domain.getId());
		}
		districtAreaService.createByBatch(areaList);
	}

	@Transactional
	public void delete(long id) {
		// TODO 需要检测是否有用户在使用
		districtDao.delete(id);
		districtAreaService.deleteByDistrict(id);
	}

	public Map<String, Object> get(long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		District district = districtDao.get(id);
		result.put("id", district.getId());
		result.put("name", district.getName());
		result.put("memo", district.getMemo());
		result.put("districtAreas", districtAreaService.queryByDistrict(id));
		return result;
	}
	
	public PageDto<District> queryByPage(String name, int pageIndex, int pageSize) {
		int total = districtDao.getCount(name);
		if (total <= 0) {
			return new PageDto<District>(total, new ArrayList<District>());
		}
		int offset = pageSize * (pageIndex - 1);
		List<District> list = districtDao.queryByPage(name, pageSize, offset);
		return new PageDto<District>(total, list);
	}
}
