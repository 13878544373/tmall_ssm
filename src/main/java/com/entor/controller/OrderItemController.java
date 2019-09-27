package com.entor.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entor.entity.Ordergl;
import com.entor.service.OrderItemService;

@Controller
public class OrderItemController {

	@Resource
	private OrderItemService ois;
	
	@RequestMapping("/admin_order_list")
	public String queryAll(HttpServletRequest req) {
		List<Ordergl> list = ois.queryAll();
		req.setAttribute("os", list);
		System.out.println(list);
		return "admin/listOrder";
	}
}
