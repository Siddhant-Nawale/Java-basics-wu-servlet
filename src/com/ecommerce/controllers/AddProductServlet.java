package com.ecommerce.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wu.ecommerce.dto.Product;
import com.wu.ecommerce.dto.User;
import com.wu.ecommerce.exception.InvalidIdException;
import com.wu.ecommerce.exception.InvalidPriceException;
import com.wu.ecommerce.repo.ProductRepositoryImpl;
import com.wu.ecommerce.service.ProductService;
import com.wu.ecommerce.service.ProductServiceImpl;
import com.wu.ecommerce.service.UserService;
import com.wu.ecommerce.service.UserServiceImpl;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet(urlPatterns = "/add-product", name = "ProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher requestDispatcher =request.getRequestDispatcher("WEB-INF/views/product.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		Product product = new Product();
		System.out.println(1);
		String productId = request.getParameter("productId");
		String productName = request.getParameter("productName");
		int productPrice = Integer.parseInt(request.getParameter("price"));
		String productCategoryName = request.getParameter("categoryName");
		
		System.out.println(2);
		System.out.println(productId);
		System.out.println(productName);
		System.out.println(productCategoryName);
		System.out.println(productPrice);
		
		if( productId != null&& productName != null&& productCategoryName!= null) {
			try {
				product.setProductId(productId);
			} catch (InvalidIdException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				product.setPrice(productPrice);
				
			} catch (InvalidPriceException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}
			
			product.setProductName(productName);
			product.setCategoryName(productCategoryName);
			ProductService productService = ProductServiceImpl.getInstance();
			Product product2 = null;
			try {
				product2 = productService.addProduct(product);
				System.out.println(product2);
				if (product2 != null) {
					System.out.println(6);
					HttpSession httpSession = request.getSession();
					httpSession.setAttribute("productList", product2);
					RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/dashboard.jsp");
					dispatcher.forward(request, response);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}

}
