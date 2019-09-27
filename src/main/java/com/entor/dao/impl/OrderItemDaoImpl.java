package com.entor.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entor.dao.OrderItemDao;
import com.entor.entity.OrderItem;
import com.entor.entity.Ordergl;

@Repository("orderItemDao")

public class OrderItemDaoImpl extends BaseDaoImpl<OrderItem> implements OrderItemDao{

	private final String namespace = "OrderItem";
	@Override
	public List<Ordergl> queryAll() {
		return getSqlSession().selectList(namespace+".queryAll");
	}

	
}
