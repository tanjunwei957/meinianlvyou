package com.atguigu.bean;

import java.util.List;

public class Page<T> {

	private String pageNo;//客户端传输到服务器的当前页的页码
	
	private Integer pageSize = 4;//每页显示的条数
	
	private Integer pageNumber;//真正访问的页码数，即将pageNo转换为Integer类型之后的结果
	
	private Integer totalCount;//数据库中的总记录数
	
	private Integer totalPageNo;//总页数
	
	private List<T> list;//当前页所对应的数据
	
	private Integer index;//当前页的起始索引
	
	private String path;//当前索访问的请求路径
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getIndex() {
		return (getPageNumber() - 1) * pageSize;
	}
	
	public Page(String pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNumber() {
		
		pageNumber = 1;
		
		try {
			pageNumber = Integer.valueOf(pageNo);
		} catch (NumberFormatException e) {}
		
		if(pageNumber <= 0) {
			pageNumber = 1;
		}
		
		if(pageNumber > getTotalPageNo()) {
			pageNumber = getTotalPageNo();
		}
		
		return pageNumber;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalPageNo() {
		
		//获取总页数
		totalPageNo = 0;
		if(totalCount % pageSize == 0) {
			totalPageNo = totalCount / pageSize;
		}else {
			totalPageNo = totalCount / pageSize + 1;
		}
		
		return totalPageNo;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
}
