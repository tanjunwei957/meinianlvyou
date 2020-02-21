package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.OrderItem;

public interface OrderItemDao {

	void saveorderItem(OrderItem orderItem);
//根据订单id获得所有的订单项；
	List<OrderItem> getOrderItemListByOrderId(String OrderId);
}
