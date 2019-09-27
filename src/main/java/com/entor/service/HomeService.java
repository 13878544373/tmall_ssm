package com.entor.service;

import java.util.List;

import com.entor.entity.Category;

public interface HomeService {

	/**
	 * 全查询商品分类
	 * @return
	 */
	List<Category> queryAll();
}
