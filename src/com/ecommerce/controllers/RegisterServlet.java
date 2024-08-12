package com.ecommerce.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wu.ecommerce.dto.Product;
import com.wu.ecommerce.dto.User;
import com.wu.ecommerce.exception.DataNotFoundException;
import com.wu.ecommerce.exception.InvalidIdException;
import com.wu.ecommerce.exception.InvalidPriceException;
import com.wu.ecommerce.exception.UserIdInvalidException;
import com.wu.ecommerce.service.ProductService;
import com.wu.ecommerce.service.ProductServiceImpl;
import com.wu.ecommerce.service.UserService;
import com.wu.ecommerce.service.UserServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(urlPatterns = "/register", name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/registerPage.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		System.out.println("apple");

		User user = new User();
		String userId = req.getParameter("userId");
		if (userId.isEmpty()) {
			// somthing
		} else {
			try {
				user.setUserId(userId);
			} catch (UserIdInvalidException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		String userEmail = req.getParameter("email");
		if (userEmail.isEmpty()) {
			// somthing
		} else {
			user.setEmail(userEmail);
		}

		String userPassword = req.getParameter("password");
		if (userPassword.isEmpty()) {
			// somthing
		} else {
			user.setPassword(userPassword);
		}

		UserService userService = UserServiceImpl.getInstanve();
		ProductService productService = ProductServiceImpl.getInstance();
		User user2 = null;
		try {
			user2 = userService.addUser(user);
			if (user2 != null) {
				HttpSession httpSession = req.getSession();
				ServletContext serviceContext = req.getServletContext();
				List<Product> products = productService.getProducts();
				System.out.println("printing products: "+products);
				serviceContext.setAttribute("productList", products);

				httpSession.setAttribute("user", user2);

				RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/views/dashboard.jsp");
				dispatcher.forward(req, resp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidPriceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
