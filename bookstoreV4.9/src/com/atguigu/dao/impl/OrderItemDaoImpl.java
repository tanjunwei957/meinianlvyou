package com.atguigu.dao.impl;

import java.util.List;

import com.atguigu.bean.OrderItem;
import com.atguigu.dao.BaseDao;
import com.atguigu.dao.OrderItemDao;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao{

	@Override
	public void saveorderItem(OrderItem orderItem) {
	String sql="insert into bs_orderitem values(null,?,?,?,?,?,?,?,?)";
	update(sql, orderItem.getBookId(),orderItem.getAuthor(),orderItem.getTitle(),orderItem.getPrice(),orderItem.getImgPath(),orderItem.getCount(),orderItem.getAmount(),orderItem.getOrderId());
	
		
	}

	@Override
	public List<OrderItem> getOrderItemListByOrderId(String OrderId) {
		String sql="select id,bookId,title,author,price,img_path imgPath,count,amount,orderId from bs_orderitem where orderId = ?";
		return getBeanList(OrderItem.class, sql, OrderId);
	}

}
