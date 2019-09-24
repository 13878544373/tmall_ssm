package com.entor.dao.impl;

import org.springframework.stereotype.Repository;

import com.entor.dao.OrderDao;
import com.entor.entity.Order;
@Repository("orderDao")
public class OrderDaoImpl extends BaseDaoImpl<Order> implements OrderDao{

}
