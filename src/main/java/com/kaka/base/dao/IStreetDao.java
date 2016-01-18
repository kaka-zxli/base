package com.kaka.base.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kaka.base.domain.Street;

public interface IStreetDao {

	void create(Street domain);

	List<Street> queryAll();

	List<Street> queryByPage(@Param("name") String name, @Param("pageSize") int pageSize, @Param("offset") int offset);

	int getCount(@Param("name") String name);

	void delete(long id);

	void update(Street domain);

	Street get(long id);
}
