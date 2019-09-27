package com.entor.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entor.dao.HomeDao;
import com.entor.entity.Category;
import com.entor.service.HomeService;

@Service("homeService")
public class HomeServiceImpl implements HomeService{

	@Resource
	private HomeDao homeDao;
	@Override
	public List<Category> queryAll() {
		return homeDao.queryAll();
	}

}
