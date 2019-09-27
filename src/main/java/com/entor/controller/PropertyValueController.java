package com.entor.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.output.WriterOutputStream;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entor.entity.Category;
import com.entor.entity.ProValPro;
import com.entor.entity.Product;
import com.entor.entity.Property;
import com.entor.entity.PropertyValue;
import com.entor.service.CategoryService;
import com.entor.service.ProductService;
import com.entor.service.PropertyService;
import com.entor.service.PropertyValueService;

@Controller
public class PropertyValueController {

	@Resource
	private ProductService pus;
	@Resource
	private PropertyValueService ppvs;
	@Resource
	private CategoryService cs;
	
	@RequestMapping("/admin_propertyValue_edit")
	public String setValue(int pid,HttpServletRequest req) {
		Product p = pus.queryById(Product.class, pid);
		int cid = p.getCid();
		Category c = cs.queryById(Category.class, cid);
		List<ProValPro> pvs = ppvs.queryPid(pid);
		req.setAttribute("pvs", pvs);
		req.setAttribute("p", p);
		req.setAttribute("c", c);
		return "admin/editPropertyValue";
	}
	
	@RequestMapping("/admin_propertyValue_update")
	public void setValue(String id,String value,HttpServletResponse res) throws IOException {
		ppvs.updateByPVId(id, value);
		PrintWriter out = res.getWriter();
		out.write("success");
		out.flush();
		out.close();
	}
}
