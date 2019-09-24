package com.entor.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.entity.User;
import com.entor.service.UserService;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService service = (UserService)context.getBean("userService");
		User user = service.queryById(User.class, 1);
		System.out.println(user);
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
