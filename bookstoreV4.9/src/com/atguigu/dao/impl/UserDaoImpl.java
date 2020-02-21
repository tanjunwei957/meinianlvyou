package com.atguigu.dao.impl;

import com.atguigu.bean.User;
import com.atguigu.dao.BaseDao;
import com.atguigu.dao.UserDao;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public User checkLogin(String username, String password) {
		String sql = "select id,username,password,email from user where username = ? and password = ?";
		return getBean(User.class, sql, username, password);
	}

	@Override
	public int registUser(User user) {
		String sql = "insert into user values(null,?,?,?)";
		return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
	}

	@Override
	public User checkUserName(String username) {
		String sql = "select id,username,password,email from user where username = ?";
		return getBean(User.class, sql, username);
	}

}
