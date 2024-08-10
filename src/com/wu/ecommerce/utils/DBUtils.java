package com.wu.ecommerce.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
	public static void main(String[] args) {
		Connection connection;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = getInstance().getConnection();
			System.out.println(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static DBUtils dbUtils;

	private DBUtils() {
		// TODO Auto-generated constructor stub
	}

	public static DBUtils getInstance() {
		if (dbUtils == null) {
			dbUtils = new DBUtils();
		}
		return dbUtils;
	}

	public Connection getConnection() throws SQLException {
		Properties properties = getInstance().loadProperties();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connection = DriverManager.getConnection(properties.getProperty("jdbc.url"),
				properties.getProperty("jdbc.username"), properties.getProperty("jdbc.password"));
		return connection;
	}

	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Properties loadProperties() {
		Properties properties = new Properties();
		try (InputStream inputStrem = DBUtils.class.getClassLoader().getResourceAsStream("application.properties")) {
			properties.load(inputStrem);
		} catch (IOException i) {
			// TODO: handle exception
			System.out.println("exception cought");
		}
		return properties;
	}
}
