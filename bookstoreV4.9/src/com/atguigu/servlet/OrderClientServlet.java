package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atguigu.bean.Cart;
import com.atguigu.bean.Order;
import com.atguigu.bean.OrderItem;
import com.atguigu.bean.User;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class OrderClientServlet
 */
public class OrderClientServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
   private  OrderService orderService=new OrderServiceImpl();
  
	
	protected void checkout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		User user = (User) session.getAttribute("user");
		//获取用户信息
		/*
		//判断
		if(user==null) {
			request.setAttribute("erroMsg", "结账操作需要先登录");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}else {*/
			//生成订单
			String orderId=orderService.createOrder(cart,user);
			session.removeAttribute("cart");
			session.setAttribute("orderId", orderId);
			response.sendRedirect(request.getContextPath()+"/pages/cart/checkout.jsp");
			//支付
			
		
	}
	
	protected void getOrdersByuserId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取订单详情
		//获取当前用户的id 
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String userId = user.getId()+"";
		//获取所有的订单 
		List<Order> orderList = orderService.getOrderListByUserId(userId);
		//再放在域中
		request.setAttribute("orderList", orderList);
		//通过转发到达我的订单页面
		request.getRequestDispatcher("/pages/order/order.jsp").forward(request, response);
		
	}
	
	protected void getOrderItemByOrderId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//查看详情
		//，通过订单id查看订单项；
		//获取请求参数
		String orderId = request.getParameter("orderId");
		//通过service方法来获取
		List<OrderItem> itemByOrderId = orderService.getOrderItemByOrderId(orderId);
		//转发加请求域
		request.setAttribute("itemByOrderId", itemByOrderId);
		
		request.getRequestDispatcher("/pages/order/orderItem.jsp").forward(request, response);
		
	}
	protected void getGoods(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//获取请求参数
		String orderId = request.getParameter("orderId");
		//调用service处理业务逻辑
		orderService.getGoods(orderId);
		//使用重定向再次访问我的订单功能
		response.sendRedirect(request.getContextPath() + "/OrderClientServlet?method=getOrdersByuserId");
		
	}
	
	
}
