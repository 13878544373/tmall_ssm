package com.entor.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

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
		return "admin/listCategory";
	}
	@RequestMapping("/admin_category_delete/{currentPage}/{id}")
	public String deleteById(@PathVariable String currentPage,@PathVariable int id) {
		cs.deleteById(Category.class, id);
		System.out.println(id);
		
		return "redirect:/admin_category_list/"+currentPage;
	}
	
	@RequestMapping("/admin_category_edit")
	public String edit(int id,String name,int currentPage,HttpServletRequest req) {
		System.out.println(id);
		Category c = new Category();
		c = cs.queryById(c.getClass(), id);
		req.setAttribute("c", c);
		return "admin/editCategory";
	}
	
	@RequestMapping("/admin_category_add")
	public String add(MultipartFile file,int currentPage,String name,HttpServletRequest request) throws IllegalStateException, IOException {
		String path = "D:\\sph\\tmall_ssm\\src\\main\\webapp\\img\\category";
		Category c = new Category();
		c.setName(name);
		cs.add(c);
		int id = c.getId();
		if (file!=null) {
			//文件类型
			String contentType = file.getContentType();
			//文件名称
			String fileName = file.getOriginalFilename();
			//文件大小
			long fileSize = file.getSize();
			System.out.println("文件类型:"+contentType);
			System.out.println("文件名称:"+fileName);
			System.out.println("文件大小:"+fileSize);
			String ty = fileName.substring(fileName.lastIndexOf("."));
			String newFileName = id+ty;
			file.transferTo(new File(path,newFileName));
		}
		request.setAttribute("c", c);
		return "redirect:/admin_category_list/"+currentPage;
	}
	@RequestMapping("/admin_category_update")
	public String update(MultipartFile file,int currentPage,int id,String name,HttpServletRequest request) throws IllegalStateException, IOException {
		String path = "D:\\sph\\tmall_ssm\\src\\main\\webapp\\img\\category";
		Category c = new Category();
		c.setName(name);
		c.setId(id);
		cs.update(c);
		try {
		if (file!=null) {
			//文件类型
			String contentType = file.getContentType();
			//文件名称
			String fileName = file.getOriginalFilename();
			//文件大小
			long fileSize = file.getSize();
			String ty = fileName.substring(fileName.lastIndexOf("."));
			System.out.println(ty);
			System.out.println(id);
			String newFileName = id+ty;
			file.transferTo(new File(path,newFileName));
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/admin_category_list/"+currentPage;
	}
	
	
}
