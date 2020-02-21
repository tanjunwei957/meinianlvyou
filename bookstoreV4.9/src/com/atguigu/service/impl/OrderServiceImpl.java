package com.atguigu.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.bean.Cart;
import com.atguigu.bean.CartItem;
import com.atguigu.bean.Order;
import com.atguigu.bean.OrderItem;
import com.atguigu.bean.User;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.OrderDao;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.service.OrderService;

public class OrderServiceImpl implements OrderService {
	private OrderDao orderDao = new OrderDaoImpl();
	private OrderItemDao orderItemDao = new OrderItemDaoImpl();
	private BookDao bookDao=new BookDaoImpl();

	@Override
	public String createOrder(Cart cart, User user) {
		// 创建订单，封装订单对象， 放入dao中，用添加语句
		String orderId = System.currentTimeMillis() + "";// 时间所对应的毫秒数；
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String createtime = sdf.format(date);
		Order order = new Order(orderId, createtime, cart.gettotalCount(), cart.gettotalamount(), 0, user.getId());
		orderDao.saveOrder(order);
		// 穿建订单项
		// 获取购物车中的购物项；
		List<CartItem> list = cart.getcartItemList();
		for (CartItem cartItem : list) {
			Book book = cartItem.getBook();
			OrderItem orderItem = new OrderItem(null, book.getId(), book.getTitle(), book.getAuthor(), book.getPrice(),
					book.getImgPath(), cartItem.getCount(), cartItem.getAmount(), orderId);
			orderItemDao.saveorderItem(orderItem);
			//更新库存和销量
			bookDao.updateSellAndBuy(book.getId(),cartItem.getCount());
		}

		return orderId;
	}

	@Override
	public List<Order> getOrderListByUserId(String userId) {
		//获取所有用户id的所有订单；
		return orderDao.getOrderListbyId(userId);
	}

	@Override
	public List<Order> getOrderListAll() {
		// TODO Auto-generated method stub
		return orderDao.getOrderAll();
	}

	@Override
	public void sendGoods(String orderId) {
		orderDao.updateOrderStatu(orderId, 1);//发货处理
		
	}

	@Override
	public void getGoods(String orderId) {
		orderDao.updateOrderStatu(orderId, 2);
		
	}

	@Override
	public List<OrderItem> getOrderItemByOrderId(String orderId) {
		
		return orderItemDao.getOrderItemListByOrderId(orderId);
	}

}
