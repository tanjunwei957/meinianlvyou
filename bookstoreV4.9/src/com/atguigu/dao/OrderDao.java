package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.Order;

public interface OrderDao {
//保存
	
	void saveOrder(Order order);

	
	//根据id查看订单详情；
	 List<Order> getOrderListbyId(String userId);
	 
	//查看所有的订单信息；
	List<Order> getOrderAll();
	
	//查看订单状态项
	void updateOrderStatu(String orderId,Integer state);
}
