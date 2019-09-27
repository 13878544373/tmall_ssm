package com.entor.service;

import java.util.List;

import com.entor.entity.ProductImage;

public interface ProductImageService extends BaseService<ProductImage>{

	public int queryByPid(int pid);
	List<ProductImage> queryByPidAll(int pid);
}
