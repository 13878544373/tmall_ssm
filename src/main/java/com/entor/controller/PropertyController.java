package com.entor.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entor.entity.Category;
import com.entor.entity.Property;
import com.entor.service.CategoryService;
import com.entor.service.PropertyService;
@Controller
public class PropertyController {
	
	@Resource
	private PropertyService ps;
	@Resource
	private CategoryService cs;
	
	@RequestMapping("/admin_property_list")
	public String queryByCid(Map<String,Object> map,int cid) {
		List<Property> list = ps.queryByCid(cid);
		Category category = cs.queryById(Category.class, cid);
		map.put("ps", list);
		map.put("c", category);
		System.out.println(list);
		System.out.println(category);
		return "admin/listProperty";
	}
	
	@RequestMapping("/admin_property_edit/{id}")
	public String update(int id,HttpSession sess) {
		//获取属性对象
		Property p = ps.queryById(Property.class, id);
		sess.setAttribute("p", p);
		return "admin/editProperty";
	}
	}
