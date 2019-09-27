package com.entor.test;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.entity.Product;
import com.entor.entity.Property;
import com.entor.entity.User;
import com.entor.service.ProductImageService;
import com.entor.service.ProductService;
import com.entor.service.PropertyService;
import com.entor.service.UserService;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductImageService service = (ProductImageService)context.getBean("productImageService");
		int id = service.queryByPid(87);
//		List<Product> user = service.queryByCidPage(83, 1, 3);
		System.out.println(id);
//		Product p = new Product();
//		System.out.println(p);
		
		/*
		List<User> list = service.queryByPage(User.class, 1, 20);
		for(User user:list) {
			System.out.println(user);
		}
		*/
//		int totals = service.getTotals(User.class);
//		System.out.println(totals);
//		service.deleteById(User.class, 16);
		/*
		User user = new User();
		user.setUsername("lisi");
		user.setPassword("123456");
		service.add(user);
		*/
		/*
		User user = new User();
		user.setId(17);
		user.setUsername("lisi7");
		user.setPassword("888888");
		service.update(user);
		*/
	}
}
