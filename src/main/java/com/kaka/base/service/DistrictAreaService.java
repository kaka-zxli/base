package com.kaka.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaka.base.dao.IDistrictAreaDao;
import com.kaka.base.domain.DistrictArea;

@Service
public class DistrictAreaService {
	@Autowired
	IDistrictAreaDao districtAreaDao;

	public void createByBatch(List<DistrictArea> list) {
		if (list != null && !list.isEmpty()) {
			districtAreaDao.createByBatch(list);
		}
	}

	public void deleteByDistrict(long districtId) {
		districtAreaDao.deleteByDistrict(districtId);
	}

	public List<DistrictArea> queryByDistrict(long districtId) {
		return districtAreaDao.queryByDistrict(districtId);
	}
}
