package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;

public interface BookDao {

	
	
	/**
	 * 获取分页数据
	 * @param maxPrice 
	 * @param minPrice 
	 */
	List<Book> getPageBook(Page<Book> page);
	
	/**
	 * 获取bs_books的总记录数
	 * @param maxPrice 
	 * @param minPrice 
	 */
	Integer getCount();
	
	/**
	 * 查询所有的图书信息
	 */
	List<Book> getBookList();
	
	/**
	 * 根据id获取某个图书信息
	 */
	Book getBookById(Integer id);

	/**
	 * 修改图书信息
	 */
	void updateBook(Book book);
	
	/**
	 * 添加图书信息
	 */
	void insertBook(Book book);
	
	/**
	 * 根据id删除图书信息
	 */
	void deleteBook(Integer id);
/**
 * 
 更新；
 */
	void updateSellAndBuy(Integer id,Integer count);

}
