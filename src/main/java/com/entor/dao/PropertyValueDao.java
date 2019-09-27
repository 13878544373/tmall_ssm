package com.entor.dao;

import java.util.List;
import java.util.Map;

import com.entor.entity.ProValPro;
import com.entor.entity.PropertyValue;

public interface PropertyValueDao extends BaseDao<PropertyValue>{

	List<ProValPro> queryPid(int pid);
	void updateByPVId(Map<String,String> map);
}
