package com.atguigu.dao;

import com.atguigu.bean.User;

public interface UserDao {

	User checkLogin(String username, String password);

	int registUser(User user);
	
	User checkUserName(String username);
	
}
