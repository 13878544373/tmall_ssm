package com.entor.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entor.dao.ProductDao;
import com.entor.entity.Product;

@Repository("productDao")

public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao{

	private final String namespace = "Product";
	@Override
	public List<Product> queryByCidPage(Map<String,Integer> map) {
		return getSqlSession().selectList(namespace+".queryByCidPage", map);
	}
	@Override
	public int cidByTotals(int cid) {
		
		return getSqlSession().selectOne(namespace+".cidByTotals", cid);
	}
	@Override
	public List<Product> vagueQuery(String vague) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(namespace+".vagueQuery", vague);
	}

}
