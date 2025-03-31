package com.mytech.shopmgmt.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
	private static final String URL = "jdbc:mysql://localhost:8081/t3shop?useSSL=false";
	private static final String USER = "root";
	private static final String PASSWORD = "123123";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (final ClassNotFoundException e) {
			throw new RuntimeException("MySQL Driver not found", e);
		}
	}

	  public static Connection getConnection() {
	        try {
	            return DriverManager.getConnection(URL, USER, PASSWORD);
	        } catch (SQLException e) {
	            System.err.println("❌ Database connection failed: " + e.getMessage());
	            return null;
	        }
	    }
}
