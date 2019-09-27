package com.entor.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entor.dao.ProductImageDao;
import com.entor.entity.ProductImage;
import com.entor.service.ProductImageService;
@Service("productImageService")

public class ProductImageServiceImpl extends BaseServiceImpl<ProductImage> implements ProductImageService{

	@Resource
	private ProductImageDao productImageDao;
	@Override
	public int queryByPid(int pid) {
		return productImageDao.queryByPid(pid);
	}
	@Override
	public List<ProductImage> queryByPidAll(int pid) {
		return productImageDao.queryByPidAll(pid);
	}

}
