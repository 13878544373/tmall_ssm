package com.entor.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.entor.dao.HomeDao;
import com.entor.entity.Category;

@Repository("homeDao")
public class HomeDaoImpl extends SqlSessionDaoSupport implements HomeDao{

	@Resource
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	private final String namespace = "OrderItem";
	private final String namespace1 = "Product";
	private final String namespace2 = "ProductImage";
	private final String namespace3 = "PropertyValue";
	private final String namespace4 = "User";
	private final String namespace5 = "Category";
	@Override
	public List<Category> queryAll() {
		return getSqlSession().selectList(namespace5+".queryAll");
	}

}
