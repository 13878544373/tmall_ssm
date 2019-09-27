package com.entor.dao;

import java.util.List;

import com.entor.entity.Category;

public interface HomeDao {

	/**
	 * 全查询商品分类
	 * @return
	 */
	List<Category> queryAll();
}
