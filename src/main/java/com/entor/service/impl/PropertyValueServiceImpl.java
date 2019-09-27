package com.entor.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entor.dao.PropertyValueDao;
import com.entor.entity.ProValPro;
import com.entor.entity.PropertyValue;
import com.entor.service.PropertyValueService;
@Service("propertyValueService")

public class PropertyValueServiceImpl extends BaseServiceImpl<PropertyValue> implements PropertyValueService{

	@Resource
	private PropertyValueDao propertyValueDao;
	@Override
	public List<ProValPro> queryPid(int pid) {
		
		return propertyValueDao.queryPid(pid);
	}
	@Override
	public void updateByPVId(String pvid,String value) {
		Map<String,String> map = new HashMap<String, String>();
		map.put("ptid", pvid);
		map.put("value", value);
		propertyValueDao.updateByPVId(map);
	}

}
