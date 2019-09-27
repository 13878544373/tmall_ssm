package com.entor.dao;

import java.util.List;

import com.entor.entity.Ordergl;
import com.entor.entity.ProductImage;

public interface ProductImageDao extends BaseDao<ProductImage>{

	public int queryByPid(int pid);
	List<ProductImage> queryByPidAll(int pid);
}
