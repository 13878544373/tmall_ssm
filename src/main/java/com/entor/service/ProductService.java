package com.entor.service;

import java.util.List;

import com.entor.entity.Product;

public interface ProductService extends BaseService<Product>{

	public List<Product> queryByCidPage(int cid,int currentPage,int pageSize);
	public int cidByTotals(int cid);
	List<Product> vagueQuery(String vague);
}
