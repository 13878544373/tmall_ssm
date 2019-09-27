package com.entor.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
		map.put("cid", cid);
		return "admin/listProperty";
	}
	
	@RequestMapping("/admin_property_edit")
	public String edit(int id,HttpServletRequest req) {
		//获取属性对象
		Property p = ps.queryById(Property.class, id);
		Category c = cs.queryById(Category.class, p.getCid());
		System.out.println(p);
		req.setAttribute("p", p);
		req.setAttribute("c", c);
		return "admin/editProperty";
	}
	
	@RequestMapping("/admin_property_update")
	public String update(String name,int id,int cid) {
		Property p = new Property();
		p.setCid(cid);
		p.setId(id);
		p.setName(name);
		ps.update(p);
		return "forward:/admin_property_list";
	}
	
	@RequestMapping("/admin_property_delete")
	public String delete(int id,int cid) {
		ps.deleteById(Property.class, id);
		
		return "forward:/admin_property_list";
	}
	
	@RequestMapping("/admin_property_add")
	public String add(Property p,int cid) {
		System.out.println(p);
		ps.add(p);
		return "forward:/admin_property_list";
	}
}
