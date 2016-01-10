package com.kaka.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaka.base.dao.IRoleMenuDao;
import com.kaka.base.domain.RoleMenu;

@Service
public class RoleMenuService {

	@Autowired
	IRoleMenuDao roleMenuDao;

	public void createByBatch(List<RoleMenu> list) {
		if (list != null && !list.isEmpty()) {
			roleMenuDao.createByBatch(list);
		}
	}

	public void deleteByRole(long roleId) {
		roleMenuDao.deleteByRole(roleId);
	}

	public List<RoleMenu> queryByRole(long roleId) {
		return roleMenuDao.queryByRole(roleId);
	}
}
