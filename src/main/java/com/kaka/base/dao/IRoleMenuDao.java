package com.kaka.base.dao;

import java.util.List;

import com.kaka.base.domain.RoleMenu;

public interface IRoleMenuDao {

	void createByBatch(List<RoleMenu> list);

	void deleteByRole(long roleId);

	List<RoleMenu> queryByRole(long roleId);
}
