package com.atguigu.Filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atguigu.bean.User;

/**
 * Servlet Filter implementation class Filter
 */
public class LoginFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		//获取session
		HttpSession session = request.getSession();
		//获取登录信息
		User user = (User) session.getAttribute("user");
		//判断它是否为空 ；
		 if(user==null) {
			 //提示错误信息，
			 request.setAttribute("erroMsg", "结账须登录操作");
			 //跳转页面 ；
			 request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		 }
		 else {
			chain.doFilter(request, response);
		 }
	}

  
}
