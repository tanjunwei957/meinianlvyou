package com.atguigu.bean;

public class OrderItem {
		private Integer id;
		private Integer bookId;
		private String title;
		private String author;
		private Double price;
		private String imgPath;
		private Integer count;
		private Double amount;//金额？
		private String orderId;
		public OrderItem() {
			super();
			// TODO Auto-generated constructor stub
		}
		public OrderItem(Integer id, Integer bookId, String title, String author, Double price, String imgPath,
				Integer count, Double amount, String orderId) {
			super();
			this.id = id;
			this.bookId = bookId;
			this.title = title;
			this.author = author;
			this.price = price;
			this.imgPath = imgPath;
			this.count = count;
			this.amount = amount;
			this.orderId = orderId;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getBookId() {
			return bookId;
		}
		public void setBookId(Integer bookId) {
			this.bookId = bookId;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public Double getPrice() {
			return price;
		}
		public void setPrice(Double price) {
			this.price = price;
		}
		public String getImgPath() {
			return imgPath;
		}
		public void setImgPath(String imgPath) {
			this.imgPath = imgPath;
		}
		public Integer getCount() {
			return count;
		}
		public void setCount(Integer count) {
			this.count = count;
		}
		public Double getAmount() {
			return amount;
		}
		public void setAmount(Double amount) {
			this.amount = amount;
		}
		public String getOrderId() {
			return orderId;
		}
		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}
		
		
}
