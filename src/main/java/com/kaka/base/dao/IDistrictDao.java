package com.kaka.base.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kaka.base.domain.District;

public interface IDistrictDao {

	void create(District domain);

	List<District> queryAll();

	void delete(long id);

	void update(District domain);

	District get(long id);

	List<District> queryByPage(@Param("name") String name, @Param("pageSize") int pageSize, @Param("offset") int offset);

	int getCount(@Param("name") String name);
}
