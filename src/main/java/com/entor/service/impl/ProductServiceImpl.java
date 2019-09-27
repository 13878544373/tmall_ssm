package com.entor.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entor.dao.impl.ProductDaoImpl;
import com.entor.entity.Product;
import com.entor.service.ProductService;
@Service("productService")

public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService{

	@Resource
	private ProductDaoImpl productDao;
	@Override
	public List<Product> queryByCidPage(int cid, int currentPage, int pageSize) {
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("cid", cid);
		map.put("start", (currentPage-1)*pageSize);
		map.put("pageSize", pageSize);
		List<Product> list = productDao.queryByCidPage(map);
		return list;
	}
	@Override
	public int cidByTotals(int cid) {
		return productDao.cidByTotals(cid);
	}
	@Override
	public List<Product> vagueQuery(String vague) {
		return productDao.vagueQuery(vague);
	}

}
