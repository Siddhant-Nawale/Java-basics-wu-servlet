package com.wu.ecommerce.repo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.wu.ecommerce.dto.User;
import com.wu.ecommerce.exception.DataNotFoundException;
import com.wu.ecommerce.exception.IdNotFoundException;
import com.wu.ecommerce.exception.UserIdInvalidException;

public interface UserRepository {
	public User addUser(User user) throws SQLException;
	public User getUserById(String id) throws IdNotFoundException, SQLException, UserIdInvalidException;
	
	public List<User> getUsers() throws DataNotFoundException, SQLException, UserIdInvalidException;
	public String removeUserById(String id) throws IdNotFoundException, SQLException, UserIdInvalidException;

	public User updateUserById(String id, User user) throws SQLException;
	 
}
