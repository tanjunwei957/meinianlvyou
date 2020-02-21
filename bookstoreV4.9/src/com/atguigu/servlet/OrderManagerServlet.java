package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.Order;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class OrderManagerServlet
 */
public class OrderManagerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    private OrderService orderService=new OrderServiceImpl();
	
	protected void getOrderListAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获得所有底单信息；
		List<Order> orderListAll = orderService.getOrderListAll();
		
		request.setAttribute("orderListAll", orderListAll);
		request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request, response);
		System.out.println("men");
	}
	
	protected void sendGoodsByOrderId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//根据订单id发货
		String orderId = request.getParameter("orderId");
		//调用方法；
		//发货之后赋值1， 
		orderService.sendGoods(orderId);
		//重定向；
		response.sendRedirect(request.getContextPath() + "/OrderManagerServlet?method=getOrderListAll");
		
	}
	/**
	 * 收货
	 */
	
	protected void getGoods(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取请求参数
		String orderId = request.getParameter("orderId");
		//调用方法实现收货操作
		orderService.getGoods(orderId);
		//成功重定向，
		response.sendRedirect(request.getContextPath()+"/OrderClientServlet?method=getOrdersByuserId");
	}
}
