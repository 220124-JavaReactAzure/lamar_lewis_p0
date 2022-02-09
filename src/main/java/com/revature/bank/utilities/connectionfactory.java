package com.revature.bank.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
 * singleton design pattern
 * 	-creational pattern
 * 	-restricts that only a single instance of this class can be made with the application
 * 	-
 */

public class ConnectionFactory {
	private static final ConnectionFactory connectionFactory = new ConnectionFactory();
	private Properties prop = new Properties();
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// use . properties file to hide sensitive information
	private ConnectionFactory() {
		try {
			prop.load(new FileReader("src/main/resources/db.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ConnectionFactory getInstance() {
		return connectionFactory;
	}
	
	public Connection getConnection() {
		Connection conn = null;		
		
		try {
			conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("admin"),prop.getProperty("password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

}
