package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

public class UserServlet extends BaseServlet {

	/**
	 * 使用条件： 1、请求此servlet时必须携带method 2、此servlet中一定不能重写doGet和doPost
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();

	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username:" + username + ",password:" + password);
		User user = userService.checkLogin(username, password);
		// 判断通过用户名和密码所获取的用户信息是否为null
		if (user != null) {
			// 将用户信息存储在session域中
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			// 成功，重定向
			response.sendRedirect(request.getContextPath() + "/pages/user/login_success.jsp");
		} else {
			// 登录失败，在请求域中存储错误信息
			request.setAttribute("errorMsg", "用户名或密码错误");
			// 失败，转发
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}
	}

	protected void regist_sync(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		// 调用service处理业务逻辑
		User user = new User(null, username, password, email);
		boolean flag = userService.registUser(user);
		if (flag) {
			// 注册成功，重定向
			response.sendRedirect(request.getContextPath() + "/pages/user/regist_success.jsp");
		} else {
			// 失败，即用户名已经被注册，实现转发跳转到注册页面
			request.setAttribute("errorMsg", "用户名已存在");
			request.setAttribute("username", username);
			request.setAttribute("email", email);
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}
	}

	protected void regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 非同步；
		// 获取请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String code = request.getParameter("code");
		// 比较验证码 ,
		HttpSession session = request.getSession();
		String codeImg = (String) session.getAttribute("codeImg");
		// 调用service处理业务逻辑
		if (code.equals(codeImg)) {
			User user = new User(null, username, password, email);
			boolean flag = userService.registUser(user);
			if (flag) {
				// 注册成功，重定向
				response.getWriter().print("success");
			} else {
				// 失败，即用户名已经被注册，实现转发跳转到注册页面
				response.getWriter().print("username");
			}
		} else {
			response.getWriter().print("code");
		}

	}

	protected void logOut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 实现登出
		HttpSession session = request.getSession();
		// 第一种：，删除域对象
		session.invalidate();
		// 第二种
		// session.removeAttribute("user");
		// 重定向
		response.sendRedirect(request.getContextPath() + "/index.jsp");

	}
}
