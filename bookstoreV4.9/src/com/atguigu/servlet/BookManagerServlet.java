package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtil;

public class BookManagerServlet extends BaseServlet {
	
	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookServiceImpl();
	
	
	protected void getPageBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//获取请求参数pageNo
		String pageNo = request.getParameter("pageNo");
		//调用service处理业务逻辑
		Page<Book> page = bookService.getPageBook(pageNo);
		//获取请求路径
		String path = WebUtil.getRequestPath(request);
		page.setPath(path);
		//将page对象放在请求域中
		request.setAttribute("page", page);
		//转发跳转到分页信息展示页面
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
	}
	
	/**
	 * 获取所有的图书信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getBookList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//调用service处理业务逻辑
		List<Book> list = bookService.getBookList();
		//将查询的所有图书信息放在请求域中
		request.setAttribute("list", list);
	
		//通过转发跳转到book_manager.jsp，将所有的图书信息进行展示
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
		
	}
	
	/**
	 * 删除图书信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void deleteBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取请求参数：要删除的图书id
		String bookId = request.getParameter("bookId");
		//将字符串类型的bookId转换为Integer
		Integer id = Integer.valueOf(bookId);
		//调用service处理业务逻辑
		bookService.deleteBook(id);
		//重定向到列表页面
		response.sendRedirect(request.getContextPath() + "/BookManagerServlet?method=getPageBook");
	}
	
	/**
	 * 
	 * 添加图书信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void insertBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//获取请求参数
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		String sales = request.getParameter("sales");
		String stock = request.getParameter("stock");
		
		//将图书相关数据封装到Book
		Book book = new Book(null, title, author, Double.valueOf(price), Integer.valueOf(sales), Integer.valueOf(stock), "static/img/default.jpg");
		//调用service处理业务逻辑
		bookService.insertBook(book);
		//重定向跳转到图书列表功能
		response.sendRedirect(request.getContextPath() + "/BookManagerServlet?method=getPageBook");
	}
	
	/**
	 * 根据id获取图书信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getBookById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//获取请求参数
		String bookId = request.getParameter("bookId");
		//将字符串类型的bookId转换为Integer类型
		Integer id = Integer.valueOf(bookId);
		//调用service处理业务逻辑
		Book book = bookService.getBookById(id);
		//将图书信息放在请求域中
		request.setAttribute("book", book);
		//通过转发跳转到pages/manager/book_edit.jsp
		request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
		
	}
	
	/**
	 * 修改图书信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//获取请求参数
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		String sales = request.getParameter("sales");
		String stock = request.getParameter("stock");
		
		//将图书相关数据封装到Book
		Book book = new Book(Integer.valueOf(id), title, author, Double.valueOf(price), Integer.valueOf(sales), Integer.valueOf(stock), null);
		//调用service处理业务逻辑
		bookService.updateBook(book);
		//重定向跳转到列表功能
		response.sendRedirect(request.getContextPath() + "/BookManagerServlet?method=getPageBook");
		
	}
	
	/**
	 * 编辑图书信息，能实现修改和添加功能
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void editBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//获取请求参数
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		String sales = request.getParameter("sales");
		String stock = request.getParameter("stock");
		
		if(id.equals("")) {
			//添加
			//将图书相关数据封装到Book
			Book book = new Book(null, title, author, Double.valueOf(price), Integer.valueOf(sales), Integer.valueOf(stock), "static/img/default.jpg");
			//调用service处理业务逻辑
			bookService.insertBook(book);
		}else {
			//修改
			//将图书相关数据封装到Book
			Book book = new Book(Integer.valueOf(id), title, author, Double.valueOf(price), Integer.valueOf(sales), Integer.valueOf(stock), null);
			//调用service处理业务逻辑
			bookService.updateBook(book);
		}
		
		//重定向跳转到列表功能
		response.sendRedirect(request.getContextPath() + "/BookManagerServlet?method=getPageBook");
		
	}
		
		
}
