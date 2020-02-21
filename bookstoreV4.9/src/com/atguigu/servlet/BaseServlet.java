package com.atguigu.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通过反射处理请求的方法
 */
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String method = request.getParameter("method");
		
		try {
			if(!"".equals(method) && method != null) {
				//获取一个方法名和method的值一致的方法，此方法中必须有两个参数，request和response
				Method m = this.getClass().getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
				//忽略方法的访问权限
				m.setAccessible(true);
				//调用此方法
				m.invoke(this, request, response);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
}
