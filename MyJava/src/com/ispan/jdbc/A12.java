package com.ispan.jdbc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import org.mindrot.jbcrypt.BCrypt;



public class A12 {
	private static final String URL = "jdbc:mysql://localhost:3306/iii";
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String SQL_QUERY = """
			SELECT id, account, icon
			FROM member
			WHERE id = ?
		""";	
	
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
		
		try (Connection conn = DriverManager.getConnection(URL, prop);) {
			
			PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY);
			pstmt.setInt(1, 2);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				InputStream in = rs.getBinaryStream("icon");
				byte[] buf = in.readAllBytes();
				
				String fileName = "dir2/" + rs.getString("account") + ".jpg"; 
				FileOutputStream out = new FileOutputStream(fileName);
				out.write(buf);
				out.flush();
				out.close();
				
				System.out.println("OK");
				
			}else {
				System.out.println("NOT FOUND!");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}