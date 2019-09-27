package com.entor.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entor.entity.Category;
import com.entor.entity.Product;
import com.entor.service.CategoryService;
import com.entor.service.ProductImageService;
import com.entor.service.ProductService;

@Controller
public class ProductController {

	@Resource
	private ProductService pus;
	@Resource 
	private ProductImageService pis;
	@Resource
	private CategoryService cs;
	
	@RequestMapping("/admin_product_list/{currentPage}")
	public String queryByCidPage(@PathVariable String currentPage,int cid,Map<String,Object> map) {
		int sp = 1;
		int pageSize = 5;
		int totals = pus.cidByTotals(cid);
		System.out.println(totals);
		int pageCounts = totals/pageSize;
		if(totals%pageSize!=0) {
			pageCounts++;
		}
		try {
		sp = Integer.parseInt(currentPage);
		}catch (Exception e) {
			sp=1;
		}
		if(sp>pageCounts) {
			sp = pageCounts;
		}
		if(sp<1) {
			sp = 1;
		}
		List<Product> list = pus.queryByCidPage(cid, sp, pageSize);
		for (Product p : list) {
			int imgId = pis.queryByPid(p.getId());
			p.setPiId(imgId);
		}
		Category c = cs.queryById(Category.class, cid);
		System.out.println(list);
		map.put("totals", totals);
		map.put("sp", sp);
		map.put("pageCounts", pageCounts);
		map.put("ps", list);
		map.put("c", c);
		return "admin/listProduct";
	}
	@RequestMapping("/admin_product_delete/{id}")
	public String deleteById(@PathVariable int id,int cid,HttpServletRequest request) {
		pus.deleteById(Product.class, id);
		System.out.println("编号"+id+"已删除");
		request.setAttribute("cid", cid);
		return "forward:/admin_product_list/1";
	}
	
	@RequestMapping("/admin_product_edit")
	public String edit(int cid, String id,HttpServletRequest req) {
		System.out.println(id);
		Product p = new Product();
		p = pus.queryById(p.getClass(), id);
		Category c = cs.queryById(Category.class, cid);
		req.setAttribute("p", p);
		req.setAttribute("c", c);
		return "admin/editProduct";
	}
	@RequestMapping("/admin_product_update")
	public String update(int id,String name,String subTitle,Float orignalPrice,Float promotePrice,int stock,int cid,HttpServletRequest request) throws IllegalStateException, IOException {
		Product p = new Product();
		p.setName(name);
		p.setId(id);
		p.setCid(cid);
		p.setSubtitle(subTitle);
		p.setOrignalprice(orignalPrice);
		p.setPromoteprice(promotePrice);
		p.setStock(stock);
		System.out.println(p);
		pus.update(p);
		request.setAttribute("cid", cid);
		return "forward:/admin_product_list/1";
	}
	
	@RequestMapping("/admin_product_add")
	public String add(String name,String subTitle,Float orignalPrice,Float promotePrice,int stock,int cid,HttpServletRequest request) throws IllegalStateException, IOException {
		Product p = new Product();
		p.setName(name);
		p.setCid(cid);
		p.setSubtitle(subTitle);
		p.setOrignalprice(orignalPrice);
		p.setPromoteprice(promotePrice);
		p.setStock(stock);
		pus.add(p);
		request.setAttribute("cid", cid);
		return "forward:/admin_product_list/1";
	}
	
}
