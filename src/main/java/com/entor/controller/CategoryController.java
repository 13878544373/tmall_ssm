package com.entor.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entor.entity.Category;
import com.entor.service.CategoryService;

@Controller
public class CategoryController {
	
	@Resource
	private CategoryService cs;
	
	@RequestMapping("/admin_category_list/{currentPage}")
	public String queryByPage(@PathVariable String currentPage,Map<String,Object> map) {
		int sp = 1;
		int pageSize = 5;
		int totals = cs.getTotals(Category.class);
		int pageCounts = totals/pageSize;
		if(totals%pageSize!=0) {
			pageCounts++;
		}
		try {
			sp = Integer.parseInt(currentPage);
		}catch(Exception e) {
			sp = 1;
		}
		if(sp>pageCounts) {
			sp = pageCounts;
		}
		if(sp<1) {
			sp = 1;
		}
		List<Category> list = cs.queryByPage(Category.class, sp, pageSize);
		map.put("totals", totals);
		map.put("sp", sp);
		map.put("pageCounts", pageCounts);
		map.put("cs", list);
		System.out.println(list);
		return "admin/listCategory";
	}
	@RequestMapping("/admin_category_delete/{currentPage}/{id}")
	public String deleteById(@PathVariable String currentPage,@PathVariable int id) {
		cs.deleteById(Category.class, id);
		System.out.println(id);
		
		return "redirect:/admin_category_list/"+currentPage;
	}
	
	@RequestMapping("/admin_category_edit")
	public String update(String id) {
		System.out.println(id);
		return "admin/editCategory";
	}
}
