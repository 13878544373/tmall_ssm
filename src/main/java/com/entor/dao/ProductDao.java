package com.entor.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.entor.entity.Product;

public interface ProductDao extends BaseDao<Product>{

	public List<Product> queryByCidPage(Map<String,Integer> map);

	public int cidByTotals(int cid);
	List<Product> vagueQuery(String vague);
}
