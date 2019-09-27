package com.entor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductImageController {

	@RequestMapping("/admin_productImage_list")
	public String queryAll() {
		return "admin/listProductImage";
	}
}
