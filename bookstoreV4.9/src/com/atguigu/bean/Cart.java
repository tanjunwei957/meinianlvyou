package com.atguigu.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 写出购物车的实体类 CartItem + 总件数，总金额 ,实现操作|：添加操作；清空购物车，删除cartitem; 修改对应的数量 （去结账）
 * 利用一个map集合来维护它；
 *
 */
public class Cart implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, CartItem> map = new LinkedHashMap<>();
	// 放入一个map 集合中
	// 有序的， 在 HashMap底层+上一对指针，
	private CartItem cartitem;
	// 总件数
	private Integer totalCount;
	// 总金额
	private Double totalamount;

	// 方便页面展示：装换为list集合：
	public List<CartItem> getcartItemList() {
		// map
		Collection<CartItem> values = map.values();
		List list = new ArrayList(values);

		return list;
	}

	// 添加购物项
	public void addCartItem(CartItem cartitem) {
		// 主功能：添加整个选项；
		// 获得其id:
		String id = cartitem.getBook().getId() + "";
		// 根据id 获取map中的购物项 ，
		CartItem cartitembyid = map.get(id);
		// 判断此购物车中是否有此图书信息，
		// 再放入map集合中；

		if (cartitembyid == null) {
			map.put(id, cartitem);
		} else {
			// 若有， 图书数量加1；
			cartitembyid.setCount(cartitembyid.getCount() + 1);

		}

	}

	// 删除购物项
	public void deleteCartItem(String id) {

		map.remove(id);
	}

	// 调整 购买数量
	public void adjustItem(String id, String count) {
		// 获取购物项；
		CartItem cartitem = map.get(id);
		// 将原来的数量赋值 ;
		Integer countint = cartitem.getCount();
		try {
			countint = Integer.valueOf(count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 若设置数量为0，删除购物项
		if (countint == 0) {
			map.remove(id);
		}
		// 默认值
		if (countint < 0) {
			countint = cartitem.getCount();
		}
		if (countint > 0) {
			cartitem.setCount(countint);
		}
	}

	// 清空购物车
	public void clearCart() {
		map.clear();
	}

	public Integer gettotalCount() {
		totalCount = 0;
		// 获取总数量；
		List<CartItem> list = getcartItemList();
		// for(集合元素的类型 局部变量 :集合对象)
		for (CartItem cartItem : list) {
			totalCount += cartItem.getCount();
		}
		return totalCount;
	}

	public Double gettotalamount() {
		totalamount = 0.0;
		BigDecimal bd1 = new BigDecimal(totalamount + "");
		// 获取总金额
		List<CartItem> list = getcartItemList();
		for (CartItem cartitem : list) {
			BigDecimal bd2 = new BigDecimal(cartitem.getAmount() + "");
			bd1=bd1.add(bd2);
		}
		return bd1.doubleValue();
	}

}
