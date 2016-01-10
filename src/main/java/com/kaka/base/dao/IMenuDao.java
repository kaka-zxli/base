package com.kaka.base.dao;

import java.util.List;

import com.kaka.base.domain.Menu;

public interface IMenuDao {

	List<Menu> queryByParent(long parentId);

}
