package com.atguigu.utils;

import javax.servlet.http.HttpServletRequest;

public class WebUtil {

	public static String getRequestPath(HttpServletRequest request) {
		/*//获取请求路径
		String uri =request.getRequestURI();
		//获取客户端传输到服务器的数据
*/		
		
		
		//获取请求路径
		String uri = request.getRequestURI();
		//获取客户端传输到服务器的数据，name=value&name=value
		String queryString = request.getQueryString();
		String path = uri + "?" + queryString;
		if(path.contains("&")) {
			path = path.substring(0, path.indexOf("&"));
		}
		return path;
	}
	
}
