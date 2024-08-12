package com.wu.ecommerce.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.wu.ecommerce.dto.Product;
import com.wu.ecommerce.exception.DataNotFoundException;
import com.wu.ecommerce.exception.IdNotFoundException;
import com.wu.ecommerce.exception.InvalidIdException;
import com.wu.ecommerce.exception.InvalidPriceException;
import com.wu.ecommerce.utils.DBUtils;

public class ProductRepositoryImpl implements ProductRepository {

	private static ProductRepository productRepository;

//	private Set<Product> products = new TreeSet<Product>(new Comparator<Product>() {
//
//		@Override
//		public int compare(Product o1, Product o2) {
//			// TODO Auto-generated method stub
//			return o1.getProductName().compareTo(o2.getProductName());
//		}
//	});
	private Set<Product> products = new TreeSet<Product>(
			(o1, o2) -> o1.getProductName().compareTo(o2.getProductName()));

//	private Product[] products = new Product[10];

	public static ProductRepository getInstance() {
		if (productRepository == null) {
			// create the object
			productRepository = new ProductRepositoryImpl();
		}
		return productRepository;
	}

	private ProductRepositoryImpl() {
		// TODO Auto-generated constructor stub

	}

	@Override
	public Product addProduct(Product product) throws SQLException {
		// TODO Auto-generated method stub
		String inserStatement = "insert into PRODUCTS (PRODUCTID, PRODUCTNAME,PRICE,CATEGORYNAME) values (?,?,?,?) ";

		Connection connection = DBUtils.getInstance().getConnection();
		// create prepared statement
		PreparedStatement preparedStatement = connection.prepareStatement(inserStatement);
		preparedStatement.setString(1, product.getProductId());
		preparedStatement.setString(2, product.getProductName());
		preparedStatement.setFloat(3, product.getPrice());
		preparedStatement.setString(4, product.getCategoryName());

		int result = preparedStatement.executeUpdate();
		System.out.println(result);
		if (result > 0) {
			return product;
		} else {
			return null;
		}
	}

	@Override
	public Product getProductByProductId(String id)
			throws IdNotFoundException, SQLException, InvalidIdException, InvalidPriceException {
		// TODO Auto-generated method stub

		String selectStatement = "select * from PRODUCTS where PRODUCTID = ?";

		Connection connection = DBUtils.getInstance().getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);

		preparedStatement.setString(1, id);

		ResultSet resultSet = preparedStatement.executeQuery();

		Product product = new Product();
		if (resultSet.next()) {
			product.setProductId(resultSet.getString("PRODUCTID"));
			product.setProductName(resultSet.getString("PRODUCTNAME"));
			product.setCategoryName(resultSet.getString("CATEGORYNAME"));
			product.setPrice(resultSet.getInt("PRICE"));
		}

		return product;
	}

	@Override
	public List<Product> getProducts()
			throws DataNotFoundException, SQLException, InvalidIdException, InvalidPriceException {
		// TODO Auto-generated method stub
		String selectStatement = "select * from PRODUCTS";

		Connection connection = DBUtils.getInstance().getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);

		ResultSet resultSet = preparedStatement.executeQuery();

		List<Product> products = new ArrayList<Product>();

		while (resultSet.next()) {
			Product product = new Product();
			product.setProductId(resultSet.getString("PRODUCTID"));
			product.setProductName(resultSet.getString("PRODUCTNAME"));
			product.setCategoryName(resultSet.getString("CATEGORYNAME"));
			product.setPrice(resultSet.getInt("PRICE"));
			products.add(product);

		}

		return products;

	}

	@Override
	public List<Product> getAllProductByCatgory(String cat)
			throws DataNotFoundException, SQLException, InvalidIdException, InvalidPriceException {
		// TODO Auto-generated method stub
		String selectStatement = "select * from PRODUCTS where CATEGORYNAME = ?";

		Connection connection = DBUtils.getInstance().getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);

		preparedStatement.setString(1, cat);

		ResultSet resultSet = preparedStatement.executeQuery();

		List<Product> products = new ArrayList<Product>();

		while (resultSet.next()) {
			Product product = new Product();
			product.setProductId(resultSet.getString("PRODUCTID"));
			product.setProductName(resultSet.getString("PRODUCTNAME"));
			product.setCategoryName(resultSet.getString("CATEGORYNAME"));
			product.setPrice(resultSet.getInt("PRICE"));
			products.add(product);
		}

		return products;

	}

	@Override
	public String removeProductByProductId(String id)
			throws IdNotFoundException, SQLException, InvalidIdException, InvalidPriceException {
		// TODO Auto-generated method stub
		String selectStatement = "delete from PRODUCTS where PRODUCTID= ?";

		Connection connection = DBUtils.getInstance().getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);

		preparedStatement.setString(1, id);

		int result = preparedStatement.executeUpdate();
		if (result > 0)
			return "success";
		return "fail";
	}

	@Override
	public Product updateProductByProjectId(String id, Product product) throws SQLException {
		// TODO Auto-generated method stub
		String selectStatement = "update PRODUCTS set PRODUCTID = ?, PRODUCTNAME = ? , PRICE = ?,CATEGORYNAME = ? where PRODUCTID = ?";

		Connection connection = DBUtils.getInstance().getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);

		preparedStatement.setString(1, product.getProductId());
		preparedStatement.setString(2, product.getProductName());
		preparedStatement.setFloat(3, product.getPrice());
		preparedStatement.setString(4, product.getCategoryName());
		preparedStatement.setString(5, id);
		
		int result = preparedStatement.executeUpdate();
		if (result > 0)
			return product;
		return null;
	}

}
