package com.atguigu.dao.impl;

import java.util.List;

import com.atguigu.bean.Order;
import com.atguigu.dao.BaseDao;
import com.atguigu.dao.OrderDao;

public class OrderDaoImpl extends BaseDao implements OrderDao{
	@Override
	public void saveOrder(Order order) {
		String sql="insert into bs_order values(?,?,?,?,?,?)";
		update(sql, order.getId(),order.getCreatetime(),order.getTotalCount(),order.getTotalAmount(),order.getState(),order.getUserId());
	}

	@Override
	public List<Order> getOrderListbyId(String userId) {
		String sql="select id ,createtime,totalCount,totalAmount,state,userId from bs_order where userId=?";
		return getBeanList(Order.class, sql, userId);
		 
	}

	@Override
	public List<Order> getOrderAll() {
		String sql="select id ,createtime,totalCount,totalAmount,state,userId from bs_order";
		return getBeanList(Order.class, sql );
	}

	@Override
	public void updateOrderStatu(String orderId,Integer state ) {
		String sql="update bs_order set state=? where id=?";
		update(sql,state,orderId);
	}}
	