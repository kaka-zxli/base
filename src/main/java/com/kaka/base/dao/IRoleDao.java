package com.kaka.base.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kaka.base.domain.Role;

public interface IRoleDao {

	void create(Role domain);

	List<Role> queryAll();

	void delete(long id);

	void update(Role domain);

	Role get(long id);
	
	List<Role> queryByPage(@Param("name") String name, @Param("pageSize") int pageSize, @Param("offset") int offset);

	int getCount(@Param("name") String name);
}
