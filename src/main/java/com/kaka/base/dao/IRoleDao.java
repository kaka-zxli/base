package com.kaka.base.dao;

import java.util.List;

import com.kaka.base.domain.Role;

public interface IRoleDao {

	void create(Role domain);

	List<Role> queryAll();

	void delete(long id);

	void update(Role domain);

	Role get(long id);
}
