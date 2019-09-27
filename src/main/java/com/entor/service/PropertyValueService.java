package com.entor.service;

import java.util.List;
import java.util.Map;

import com.entor.entity.ProValPro;
import com.entor.entity.PropertyValue;

public interface PropertyValueService extends BaseService<PropertyValue>{

	List<ProValPro> queryPid(int pid);
	void updateByPVId(String pvid,String value);
}
