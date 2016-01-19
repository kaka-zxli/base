package com.kaka.base.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaka.base.dao.IStreetDao;
import com.kaka.base.domain.Street;
import com.kaka.base.dto.PageDto;

@Service
public class StreetService {

	@Autowired
	private IStreetDao streetDao;

	@Transactional
	public void create(Street domain) {
		streetDao.create(domain);
	}

	public List<Street> queryAll() {
		return streetDao.queryAll();
	}

	@Transactional
	public void update(Street domain) {
		streetDao.update(domain);
	}

	@Transactional
	public void delete(long id) {
		// TODO 需要检测是否有用户在使用
		streetDao.delete(id);
	}

	public Street get(long id) {
		return streetDao.get(id);
	}

	public PageDto<Street> queryByPage(String name, int pageIndex, int pageSize) {
		int total = streetDao.getCount(name);
		if (total <= 0) {
			return new PageDto<Street>(total, new ArrayList<Street>());
		}
		int offset = pageSize * (pageIndex - 1);
		List<Street> list = streetDao.queryByPage(name, pageSize, offset);
		return new PageDto<Street>(total, list);
	}
}
