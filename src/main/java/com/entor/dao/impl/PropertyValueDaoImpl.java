package com.entor.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entor.dao.PropertyValueDao;
import com.entor.entity.ProValPro;
import com.entor.entity.PropertyValue;

@Repository("propertyValueDao")

public class PropertyValueDaoImpl extends BaseDaoImpl<PropertyValue> implements PropertyValueDao{

	private final String namespace = "PropertyValue";
	@Override
	public List<ProValPro> queryPid(int pid) {
		
		return getSqlSession().selectList(namespace+".queryPid", pid);
	}
	@Override
	public void updateByPVId(Map<String, String> map) {
		getSqlSession().selectList(namespace+".update", map);
	}

}
