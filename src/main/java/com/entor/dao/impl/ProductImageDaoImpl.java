package com.entor.dao.impl;

import org.springframework.stereotype.Repository;

import com.entor.dao.ProductImageDao;
import com.entor.entity.ProductImage;

@Repository("productImageDao")

public class ProductImageDaoImpl extends BaseDaoImpl<ProductImage> implements ProductImageDao{

}
