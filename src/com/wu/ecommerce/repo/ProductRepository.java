package com.wu.ecommerce.repo;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.wu.ecommerce.dto.Product;
import com.wu.ecommerce.exception.DataNotFoundException;
import com.wu.ecommerce.exception.IdNotFoundException;
import com.wu.ecommerce.exception.InvalidIdException;
import com.wu.ecommerce.exception.InvalidPriceException;

public interface ProductRepository {
	public Product addProduct(Product product) throws SQLException;
	public Product getProductByProductId(String id) throws IdNotFoundException, SQLException, InvalidIdException, InvalidPriceException;
	
	public List<Product> getProducts() throws DataNotFoundException, SQLException, InvalidIdException, InvalidPriceException;
	public List<Product> getAllProductByCatgory(String cat) throws DataNotFoundException, SQLException, InvalidIdException, InvalidPriceException;
	
	public String removeProductByProductId(String id) throws IdNotFoundException, SQLException, InvalidIdException, InvalidPriceException;
	public Product updateProductByProjectId(String id, Product product) throws SQLException;
	
	default void display(){
		System.out.println("Hello from interface");
	}
}
