package com.atguigu.bean;

public class Order {
	private String id;
	private String createtime;
	private Integer totalCount;//session中购物车中
	private Double totalAmount;//购物车中
	private Integer state;
	private Integer userId;//session中获取
	public Order(String id, String createtime, Integer totalCount, Double totalAmount, Integer state, Integer userId) {
		super();
		this.id = id;
		this.createtime = createtime;
		this.totalCount = totalCount;
		this.totalAmount = totalAmount;
		this.state = state;
		this.userId = userId;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
