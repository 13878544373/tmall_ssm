package com.entor.service;

import java.util.List;

import com.entor.entity.User;

public interface UserService extends BaseService<User>{

	public User login(String name,String password);
	public List<User> queryAll();
	User register(String name);
}
