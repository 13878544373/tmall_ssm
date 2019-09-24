package com.entor.dao.impl;

import org.springframework.stereotype.Repository;

import com.entor.dao.PropertyValueDao;
import com.entor.entity.PropertyValue;

@Repository("propertyValueDao")

public class PropertyValueDaoImpl extends BaseDaoImpl<PropertyValue> implements PropertyValueDao{

}
