package com.atguigu.service;

import java.util.List;

import com.atguigu.bean.Cart;
import com.atguigu.bean.Order;
import com.atguigu.bean.OrderItem;
import com.atguigu.bean.User;

public interface OrderService {


	
//创建订单项
	String createOrder(Cart cart, User user);
	
	//根据用户id获取
	List<Order> getOrderListByUserId(String userId);
	
	//获取所有订单
	List<Order> getOrderListAll();
	
	//更新订单状态
	//1，处理发货状态；
	void sendGoods(String orderId);
	
	//处理收货状态
	void getGoods(String orderId);

	//查看订单项详情
	List<OrderItem> getOrderItemByOrderId(String orderId);
	
	
}
