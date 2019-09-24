package com.entor.dao;

import com.entor.entity.User;

public interface UserDao extends BaseDao<User>{

	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username,String password);
}
