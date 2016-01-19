package com.kaka.base.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaka.base.dao.IRoleDao;
import com.kaka.base.domain.Role;
import com.kaka.base.domain.RoleMenu;
import com.kaka.base.dto.PageDto;

@Service
public class RoleService {

	@Autowired
	private IRoleDao roleDao;
	@Autowired
	private RoleMenuService roleMenuService;

	@Transactional
	public void create(Role domain, List<Long> menuIdList) {
		roleDao.create(domain);

		List<RoleMenu> list = new ArrayList<RoleMenu>();
		for (Long menuId : menuIdList) {
			RoleMenu roleMenu = new RoleMenu();
			roleMenu.setMenuId(menuId);
			roleMenu.setRoleId(domain.getId());
			list.add(roleMenu);
		}
		roleMenuService.createByBatch(list);
	}

	public List<Role> queryAll() {
		return roleDao.queryAll();
	}

	@Transactional
	public void update(Role domain, List<Long> menuIdList) {
		roleDao.update(domain);

		roleMenuService.deleteByRole(domain.getId());

		List<RoleMenu> list = new ArrayList<RoleMenu>();
		for (Long menuId : menuIdList) {
			RoleMenu roleMenu = new RoleMenu();
			roleMenu.setMenuId(menuId);
			roleMenu.setRoleId(domain.getId());
			list.add(roleMenu);
		}
		roleMenuService.createByBatch(list);
	}

	@Transactional
	public void delete(long id) {
		// TODO 需要检测是否有用户在使用这个角色
		roleDao.delete(id);
		roleMenuService.deleteByRole(id);
	}

	public Map<String, Object> get(long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		Role role = roleDao.get(id);
		result.put("id", role.getId());
		result.put("name", role.getName());
		result.put("memo", role.getMemo());
		result.put("roleMenus", roleMenuService.queryByRole(id));
		return result;
	}

	public PageDto<Role> queryByPage(String name, int pageIndex, int pageSize) {
		int total = roleDao.getCount(name);
		if (total <= 0) {
			return new PageDto<Role>(total, new ArrayList<Role>());
		}
		int offset = pageSize * (pageIndex - 1);
		List<Role> list = roleDao.queryByPage(name, pageSize, offset);
		return new PageDto<Role>(total, list);
	}
}
