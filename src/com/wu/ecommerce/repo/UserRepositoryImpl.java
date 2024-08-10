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
import com.wu.ecommerce.dto.User;
import com.wu.ecommerce.exception.DataNotFoundException;
import com.wu.ecommerce.exception.IdNotFoundException;
import com.wu.ecommerce.exception.UserIdInvalidException;
import com.wu.ecommerce.utils.DBUtils;

public class UserRepositoryImpl implements UserRepository {

	private UserRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public static UserRepository userRepository;
	
	private Set<User> users = new TreeSet<User>((o1,o2)->o1.getEmail().compareTo(o2.getEmail()));
	
	public static UserRepository getInstance() {
		if(userRepository == null) {
			userRepository = new UserRepositoryImpl();
		}
		return userRepository;
	}
	
	@Override
	public User addUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		String inserStatement = "insert into USER_TABLE (USER_ID,EMAIL, PASSWORD) values (?,?,?) ";

		Connection connection = DBUtils.getInstance().getConnection();
		// create prepared statement
		PreparedStatement preparedStatement = connection.prepareStatement(inserStatement);
		preparedStatement.setString(1, user.getUserId());
		preparedStatement.setString(2, user.getEmail());
		preparedStatement.setString(3, user.getPassword());
//		preparedStatement.setString(4, user.getAddress());
//		preparedStatement.setFloat(5, user.getContactNumber());
//		preparedStatement.setString(4, product.getCategoryName());
		
		int result = preparedStatement.executeUpdate();
		System.out.println(result);
		if (result>0) {
			return user;
		} else {
			return null;
		}

	}

	@Override
	public User getUserById(String id) throws IdNotFoundException, SQLException, UserIdInvalidException {
		// TODO Auto-generated method stub
		String selectStatement = "select * from USER_TABLE where USER_ID = ?";

		Connection connection = DBUtils.getInstance().getConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);
		
		preparedStatement.setString(1, id);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		User user  = new User();
		if(resultSet.next()) {
			user.setUserId(resultSet.getString("USER_ID"));
			user.setEmail(resultSet.getString("EMAIL"));
			user.setPassword(resultSet.getString("PASSWORD"));
//			user.setContactNumber(resultSet.getInt("CONTACT_NUMBER"));
//			user.setAddress(resultSet.getString("ADDRESS"));
		}
		
		return user;
	}

	@Override
	public List<User> getUsers() throws DataNotFoundException, SQLException, UserIdInvalidException {
		// TODO Auto-generated method stub
		String selectStatement = "select * from USER_TABLE";

		Connection connection = DBUtils.getInstance().getConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		List<User> users = new ArrayList<User>();
		
		while(resultSet.next()) {
			User user  = new User();
			user.setUserId(resultSet.getString("USER_ID"));
			user.setEmail(resultSet.getString("EMAIL"));
			user.setPassword(resultSet.getString("PASSWORD"));
//			user.setContactNumber(resultSet.getInt("CONTACT_NUMBER"));
//			user.setAddress(resultSet.getString("ADDRESS"));
			users.add(user);
		}
		
		return users;
	}
	
	@Override
	public String removeUserById(String id) throws IdNotFoundException, SQLException, UserIdInvalidException {
		// TODO Auto-generated method stub
		String selectStatement = "delete from USER_TABLE where USER_ID= ?";

		Connection connection = DBUtils.getInstance().getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);

		preparedStatement.setString(1, id);

		int result = preparedStatement.executeUpdate();
		if (result > 0)
			return "success";
		return "fail";

	}

	@Override
	public User updateUserById(String id, User user) throws SQLException {
		// TODO Auto-generated method stub
		String selectStatement = "update USER_TABLE set USER_ID = ? ,EMAIL = ? ,PASSWORD= ? where USER_ID = ?";

		Connection connection = DBUtils.getInstance().getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);

		preparedStatement.setString(1, user.getUserId());
		preparedStatement.setString(2, user.getEmail());
		preparedStatement.setString(3, user.getPassword());
		preparedStatement.setString(6, id);
		
		int result = preparedStatement.executeUpdate();
		if (result > 0)
			return user;
		return null;
	}

}
