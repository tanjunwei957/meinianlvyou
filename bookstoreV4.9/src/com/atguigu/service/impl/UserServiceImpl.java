package com.atguigu.service.impl;

import com.atguigu.bean.User;
import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();
	
	@Override
	public User checkLogin(String username, String password) {
		return userDao.checkLogin(username, password);
	}

	@Override
	public boolean registUser(User user) {
		/**
		 * 1、先判断用户名是否已经被注册，若被注册的情况和注册返回的结果不是1的情况，设置统一的错误提示信息为注册失败
		 * 2、只判断用户名是否已经被注册，若被注册，则设置提示信息为用户名已存在
		 */
		/*int i = userDao.registUser(user);
		if(i == 1) {
			return true;
		}*/
		
		//先判断用户名是否已经被注册
		User userSQL = userDao.checkUserName(user.getUsername());
		if(userSQL == null) {
			//根据用户名未查询到数据，表示用户名可以被注册
			userDao.registUser(user);
			return true;
		}
		//用户名已经被注册
		return false;
	}
	
	

}
