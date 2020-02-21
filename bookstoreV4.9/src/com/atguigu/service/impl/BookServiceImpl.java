package com.atguigu.service.impl;

import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.service.BookService;

public class BookServiceImpl implements BookService {

	private BookDao bookDao = new BookDaoImpl();
	
	
	
	@Override
	public Page<Book> getPageBook(String pageNo) {
		
		Page<Book> page = new Page<>(pageNo);
		
		//获取总记录数
		Integer totalCount = bookDao.getCount();
		page.setTotalCount(totalCount);
		//获取当前页所对应的图书信息
		List<Book> list = bookDao.getPageBook(page);
		page.setList(list);
		
		return page;
	}
	
	@Override
	public List<Book> getBookList() {
		return bookDao.getBookList();
	}

	@Override
	public Book getBookById(Integer id) {
		return bookDao.getBookById(id);
	}

	@Override
	public void updateBook(Book book) {
		bookDao.updateBook(book);
	}

	@Override
	public void insertBook(Book book) {
		bookDao.insertBook(book);
	}

	@Override
	public void deleteBook(Integer id) {
		bookDao.deleteBook(id);
	}

}
