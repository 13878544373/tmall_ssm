package com.entor.service;


import java.util.List;

import com.entor.entity.Property;

public interface PropertyService extends BaseService<Property>{
	
	public List<Property> queryByCid(int id);
}
