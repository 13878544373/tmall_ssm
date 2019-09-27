package com.entor.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entor.entity.User;
import com.entor.service.UserService;

@Controller
public class UserController {

	@Resource
	private UserService users;
	
	@RequestMapping("/admin_user_list")
	public String queryUser(HttpServletRequest req) {
		List<User> list = users.queryAll();
		req.setAttribute("us", list);
		return "admin/listUser";
	}
}
