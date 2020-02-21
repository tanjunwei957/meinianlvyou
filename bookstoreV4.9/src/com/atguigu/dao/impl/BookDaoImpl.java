package com.atguigu.dao.impl;

import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.dao.BaseDao;
import com.atguigu.dao.BookDao;

public class BookDaoImpl extends BaseDao implements BookDao {


	@Override
	public List<Book> getPageBook(Page<Book> page) {
		String sql = "select id,title,author,price,sales,stock,img_path imgPath from bs_books limit ?,?";
		return getBeanList(Book.class, sql, page.getIndex(), page.getPageSize());
	}

	@Override
	public Integer getCount() {
		String sql = "select count(id) from bs_books";
		long l = (Long)getSingleData(sql);
		return (int)l;
	}
	
	@Override
	public List<Book> getBookList() {
		String sql = "select id,title,author,price,sales,stock,img_path imgPath from bs_books";
		return getBeanList(Book.class, sql);
	}

	@Override
	public Book getBookById(Integer id) {
		String sql = "select id,title,author,price,sales,stock,img_path imgPath from bs_books where id = ?";
		return getBean(Book.class, sql, id);
	}

	@Override
	public void updateBook(Book book) {
		String sql = "update bs_books set title = ?, author = ?, price = ?, sales = ?, stock = ? where id = ?";
		update(sql, book.getTitle(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getId());
	}

	@Override
	public void insertBook(Book book) {
		String sql = "insert into bs_books values(null,?,?,?,?,?,?)";
		update(sql, book.getTitle(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
	}

	@Override
	public void deleteBook(Integer id) {
		String sql = "delete from bs_books where id = ?";
		update(sql, id);
	}

	@Override
	public void updateSellAndBuy(Integer id, Integer count) {
		String sql="update bs_books set sales=sales+?,stock=stock-? where id=?";
		update(sql, count,count,id);
		
		
		
	}

}
