package com.entor.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.entor.dao.PropertyDao;
import com.entor.entity.Property;

@Repository("propertyDao")

public class PropertyDaoImpl extends BaseDaoImpl<Property> implements PropertyDao{

	private final String namespace = "Property";
	@Override
	public List<Property> queryByCid(int id) {
		return getSqlSession().selectList(namespace+".queryByCid", id);
	}

}
