package com.entor.service;

import java.util.List;

import com.entor.entity.OrderItem;
import com.entor.entity.Ordergl;

public interface OrderItemService extends BaseService<OrderItem>{

	public List<Ordergl> queryAll();
}
