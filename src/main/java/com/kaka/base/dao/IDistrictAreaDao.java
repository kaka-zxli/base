package com.kaka.base.dao;

import java.util.List;

import com.kaka.base.domain.DistrictArea;

public interface IDistrictAreaDao {

	void createByBatch(List<DistrictArea> list);

	void deleteByDistrict(long districtId);

	List<DistrictArea> queryByDistrict(long districtId);
}
