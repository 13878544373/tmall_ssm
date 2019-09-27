package com.entor.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.entor.dao.ProductImageDao;
import com.entor.entity.Ordergl;
import com.entor.entity.ProductImage;

@Repository("productImageDao")

public class ProductImageDaoImpl extends BaseDaoImpl<ProductImage> implements ProductImageDao{

	private final String namespace = "ProductImage";
	@Override
	public int queryByPid(int pid) {
		try {
		int id = getSqlSession().selectOne(namespace+".queryByPid", pid);
		return id;
		}catch (Exception e) {
			return -1;
		}
	}
	@Override
	public List<ProductImage> queryByPidAll(int pid) {
		return getSqlSession().selectList(namespace+".queryByPidAll", pid);
	}

}
