package com.atguigu.Filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.utils.JDBCUtils;

/**
 * Servlet Filter implementation class TransmissionFilter
 */
public class TransmissionFilter  extends HttpFilter {
	

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Connection connection=null;
		try {//获取当前线程所对应的唯一连接
			connection = JDBCUtils.getConnection();
			connection.setAutoCommit(false);
			chain.doFilter(request, response);//拦截器链， 访问请求资源及处理的增删改查；
			connection.commit();
			
		} catch (Exception e) {
			// 出现异常
			try {
				connection.rollback();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//跳转页面
			response.sendRedirect(request.getContextPath()+"/erro.jsp");
		}finally {
			JDBCUtils.close();
		}
		
		
		
	}
	public void name(){
			Connection connection=null;
				try {
					connection = JDBCUtils.getConnection();
					connection.setAutoCommit(false);
					//增删改查；
				//	查询也需要事物处理；
					
					
					
					
				} catch (SQLException e) {
					try {
						connection.rollback();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}finally {
					JDBCUtils.close();
					
				}
	}

   

}
