package com.atguigu.bean;

import java.io.Serializable;
import java.math.BigDecimal;

//每一行的代表的东西//购物项
public class CartItem implements Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private Book book;
		//数量：
		private Integer count;
		//总金额
		private Double amount;
		public CartItem(Book book ,Integer count) {
			super();
			this.book = book;
			this.count=count;
			
		}
		
		public CartItem() {
			super();
		}

		public Book getBook() {
			return book;
		}
		public void setBook(Book book) {
			this.book = book;
		}
		public Integer getCount() {
			return count;
		}
		public void setCount(Integer count) {
			this.count = count;
		}
		public Double getAmount() {
			//计算总金额：解决double精度问题
			BigDecimal bd1=new BigDecimal(book.getPrice()+"");
			BigDecimal bd2=new BigDecimal(count+"");
			BigDecimal bd3=bd1.multiply(bd2);
			return bd3.doubleValue();
			//BigDicimal的doubleValur的方法；
		}
		
		
}
