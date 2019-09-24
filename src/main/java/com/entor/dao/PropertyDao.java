package com.entor.dao;


import java.util.List;

import com.entor.entity.Property;

public interface PropertyDao extends BaseDao<Property>{
	/**
	 * 查询型号根据id
	 * @return
	 */
	public List<Property> queryByCid(int id);
}
