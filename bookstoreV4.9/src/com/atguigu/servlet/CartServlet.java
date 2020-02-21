package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atguigu.bean.Book;
import com.atguigu.bean.Cart;
import com.atguigu.bean.CartItem;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;

/**
 * Servlet implementation class cartServlet
 */
public class CartServlet extends BaseServlet {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	BookService bookservice = new BookServiceImpl();

	protected void addBookToCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 记得去掉注释：
		// 添加图书到购物车
		// 获取请求参数：
		String bookId = request.getParameter("bookId");
		// 穿建cart对象， 调用其方法； 不能newcart ，从session中获取购物车；
		// 校验：第一次添加 ， 就new一个cart 的对象：
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");// 获得一个cart
		if (cart == null) {
			// 说明不存在cart，需要创建cart对象；
			cart = new Cart();
		}
		// 创建之后,就可以添加了， 怎么添加呢？一步一步来（1，将图书放进购物车中， 然后再将购物车放进session中）
		Book bookById = bookservice.getBookById(Integer.valueOf(bookId));
		CartItem cartitem = new CartItem(bookById,1);
		// 再将其放入cart 对象中
		cart.addCartItem(cartitem);
		// 再将其放入session更新购物车信息；cart 放进域 中 ， 才能用它；
		session.setAttribute("cart", cart);
	
		// 将图书名称也放入seesion中；
		session.setAttribute("bookName", bookById.getTitle());
		// 添加完成后，重定向到首页：
		response.sendRedirect(request.getContextPath() + "/index.jsp");
		// String previousURL = request.getHeader("referer");
		// response.sendRedirect(previousURL);

	}

	protected void deletecartitem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 删除购物项：
		String id = request.getParameter("bookId");
		// 获取session对象：uuid
		HttpSession session = request.getSession();
		// 通过session域 中的cart 来删除
		Cart cart = (Cart) session.getAttribute("cart");
		// 通过id来删除
		cart.deleteCartItem(id);
		// 或者通过请求来搞定它；
		String previousURL = request.getHeader("referer");
		response.sendRedirect(previousURL);
	}
	/*
	 * 清空购物车
	 */

	protected void clearCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		cart.clearCart();
		String previousURL = request.getHeader("referer");
		response.sendRedirect(previousURL);
	}
	
	
	/*更新购物项的数量
	 * 
	 * */
	protected void updateCount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取请求参数
		String id = request.getParameter("bookId");
		String count = request.getParameter("count");
		//通过session中的cart删除
		HttpSession session = request.getSession();
		//通过方法调出session中已有的cart对象；
		Cart cart = (Cart) session.getAttribute("cart");
		cart.adjustItem(id, count);
		String previousURL = request.getHeader("referer");
		response.sendRedirect(previousURL);
	}
	}


