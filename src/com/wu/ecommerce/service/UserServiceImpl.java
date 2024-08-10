package com.wu.ecommerce.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.wu.ecommerce.dto.User;
import com.wu.ecommerce.exception.DataNotFoundException;
import com.wu.ecommerce.exception.IdNotFoundException;
import com.wu.ecommerce.exception.UserIdInvalidException;
import com.wu.ecommerce.repo.UserRepository;
import com.wu.ecommerce.repo.UserRepositoryImpl;

public class UserServiceImpl implements UserService {

	private UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private static UserService userService;
	private static UserRepository userRepository = UserRepositoryImpl.getInstance();
	
	public static UserService getInstanve() {
		if(userService == null) {
			userService = new UserServiceImpl();
		}
		return userService;
	}


	@Override
	public User addUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		return userRepository.addUser(user);
	}

	@Override
	public User getUserById(String id) throws IdNotFoundException, SQLException, UserIdInvalidException {
		// TODO Auto-generated method stub
		return userRepository.getUserById(id);
	}

	@Override
	public List<User> getUsers() throws DataNotFoundException, SQLException, UserIdInvalidException {
		// TODO Auto-generated method stub
		return userRepository.getUsers();
	}

	@Override
	public String removeUserById(String id) throws IdNotFoundException, SQLException, UserIdInvalidException {
		// TODO Auto-generated method stub
		return userRepository.removeUserById(id);
	}

	@Override
	public User updateUserById(String id, User user) throws SQLException {
		// TODO Auto-generated method stub
		return userRepository.updateUserById(id, user);
	}

}
