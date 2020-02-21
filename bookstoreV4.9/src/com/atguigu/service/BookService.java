package com.atguigu.service;

import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;

public interface BookService {

	
	
	/**
	 * 获取分页数据
	 * @param max 
	 * @param min 
	 */
	Page<Book> getPageBook(String pageNo);
	
	/**
	 * 获取所有的图书信息
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
	 * 删除图书信息
	 */
	void deleteBook(Integer id);
	
}
