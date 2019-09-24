package com.entor.dao.impl;

import org.springframework.stereotype.Repository;

import com.entor.dao.OrderItemDao;
import com.entor.entity.OrderItem;

@Repository("orderItemDao")

public class OrderItemDaoImpl extends BaseDaoImpl<OrderItem> implements OrderItemDao{

}
