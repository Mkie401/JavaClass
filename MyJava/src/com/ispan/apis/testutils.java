package com.ispan.apis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class testutils {
	private final static String url = "jdbc:mysql://localhost:3306/iii";
	private final static String user = "root";
	private final static String passwd = "root";
	
	public static  Connection getconnection() throws Exception {
			return DriverManager.getConnection(url, user, passwd);
	}
	
}
