package com.kaka.base.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaka.base.dao.IMenuDao;
import com.kaka.base.domain.Menu;

/**
 * 菜单管理
 *
 * @author lzx
 */
@Service
public class MenuService {

	@Autowired
	private IMenuDao menuDao;

	private final static long firstMenuParentId = -1;

	public List<Map<String, Object>> queryByUser() {
		return queryByParentForTree(firstMenuParentId);
	}

	public List<Map<String, Object>> queryAllForTree() {
		return queryByParentForTree(firstMenuParentId);
	}

	private List<Map<String, Object>> queryByParentForTree(long parentId) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<Menu> menus = menuDao.queryByParent(parentId);
		for (Menu m : menus) {
			Map<String, Object> sys = new HashMap<String, Object>();
			sys.put("id", m.getId());
			sys.put("name", m.getName());
			sys.put("url", m.getUrl());
			sys.put("icon", m.getIcon());
			sys.put("children", queryByParentForTree(m.getId()));
			list.add(sys);
		}
		return list;
	}
}
