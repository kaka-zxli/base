package com.kaka.base.dao;

import java.util.List;

import com.kaka.base.domain.District;

public interface IDistrictDao {

	void create(District domain);

	List<District> queryAll();

	void delete(long id);

	void update(District domain);

	District get(long id);

}
