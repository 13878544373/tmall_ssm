package com.entor.service.impl;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entor.dao.PropertyDao;
import com.entor.entity.Property;
import com.entor.service.PropertyService;
@Service("propertyService")

public class PropertyServiceImpl extends BaseServiceImpl<Property> implements PropertyService{
	@Resource
	private PropertyDao propertyDao;
	@Override
	public List<Property> queryByCid(int id) {
		return propertyDao.queryByCid(id);
	}
}
