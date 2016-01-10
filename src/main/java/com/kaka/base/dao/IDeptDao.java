package com.kaka.base.dao;

import java.util.List;

import com.kaka.base.domain.Dept;

public interface IDeptDao {

	void create(Dept domain);

	List<Dept> queryAll();

	void delete(long id);

	void update(Dept domain);

	Dept get(long id);

	List<Dept> queryByParent(long parentId);
}
