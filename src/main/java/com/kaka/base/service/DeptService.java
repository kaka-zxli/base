package com.kaka.base.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaka.base.dao.IDeptDao;
import com.kaka.base.domain.Dept;
import com.kaka.base.exception.BusinessException;

@Service
public class DeptService {

	@Autowired
	private IDeptDao deptDao;

	private final static long firstDeptParentId = -1;

	@Transactional
	public void create(Dept domain) {
		deptDao.create(domain);
	}

	public List<Dept> queryAll() {
		return deptDao.queryAll();
	}

	@Transactional
	public void update(Dept domain) {
		if (domain.getId() == domain.getParentId()) {
			throw new BusinessException("上级部门不能是当前部门");
		}
		List<Map<String, Object>> list = queryByParentForTree(domain.getId());
		checkUpdate(domain.getParentId(), list);
		deptDao.update(domain);
	}

	private void checkUpdate(long id, List<Map<String, Object>> list) {
		for (Map<String, Object> map : list) {
			if (map.get("id").equals(id)) {
				throw new BusinessException("上级部门不能是当前部门的下级部门");
			}
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> children = (List<Map<String, Object>>) map.get("children");
			if (!children.isEmpty()) {
				checkUpdate(id, children);
			}
		}
	}

	@Transactional
	public void delete(long id) {
		// TODO 需要检测是否有用户在使用
		List<Dept> depts = deptDao.queryByParent(id);
		if (depts != null && !depts.isEmpty()) {
			throw new BusinessException("当前部门有下级部门，不能删除");
		}
		deptDao.delete(id);
	}

	public Dept get(long id) {
		return deptDao.get(id);
	}

	public List<Map<String, Object>> queryAllForTree() {
		return queryByParentForTree(firstDeptParentId);
	}

	private List<Map<String, Object>> queryByParentForTree(long parentId) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<Dept> depts = deptDao.queryByParent(parentId);
		for (Dept d : depts) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", d.getId());
			map.put("name", d.getName());
			map.put("parentId", d.getName());
			map.put("text", d.getName());
			map.put("children", queryByParentForTree(d.getId()));
			list.add(map);
		}
		return list;
	}
}
