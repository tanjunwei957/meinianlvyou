package com.atguigu.service;

import com.atguigu.bean.User;

public interface UserService {

	User checkLogin(String username, String password);

	boolean registUser(User user);
	
}
