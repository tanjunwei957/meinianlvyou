package com.atguigu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtil;


public class BookClientServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookServiceImpl();	
	
	protected void getBooks(HttpServletRequest request, HttpServletResponse response)
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
		request.getRequestDispatcher("/pages/client/books.jsp").forward(request, response);
	}

}
