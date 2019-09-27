package com.entor.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entor.dao.OrderItemDao;
import com.entor.entity.OrderItem;
import com.entor.entity.Ordergl;
import com.entor.service.OrderItemService;
import com.entor.service.ProductImageService;
@Service("orderItemService")

public class OrderItemServiceImpl extends BaseServiceImpl<OrderItem> implements OrderItemService{

	@Resource
	private OrderItemDao orderItemDao;
	@Resource 
	private ProductImageService pis;
	@Override
	public List<Ordergl> queryAll() {
		List<Ordergl> list = orderItemDao.queryAll();
		for (Ordergl o : list) {
			o.setPiid(pis.queryByPid(o.getPid()));
			String desc = o.getStatus();
			if (desc.equals("delete")) {
				o.setStatusDesc("删除");
			}else if (desc.equals("finish")) {
				o.setStatusDesc("完成");
			}
			float total = o.getPromotePrice()*o.getNumber();
			o.setTotal(total);
			if (o.getId()==1) {
				o.setTotalNumber(o.getTotalNumber()+o.getNumber());
			}else if (o.getId()==3||o.getId()==4) {
				o.setTotalNumber(1);
			}
		}
		return list;
	}

}
