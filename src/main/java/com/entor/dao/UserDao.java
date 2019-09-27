package com.entor.dao;

import java.util.List;

import com.entor.entity.User;

public interface UserDao extends BaseDao<User>{

	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username,String password);
	public List<User> queryAll();
	User register(String name);
}
