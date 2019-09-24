package com.entor.dao.impl;

import org.springframework.stereotype.Repository;

import com.entor.dao.ProductDao;
import com.entor.entity.Product;

@Repository("productDao")

public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao{

}
