package com.ispan.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class A03 {

	public static void main(String[] args) {
					//jdbc 跟 mysql 資料庫連接 mysql 資料庫跟 本機 連接
					//資料庫名稱iii 帳號root 密碼root key=values
		String url1 = "jdbc:mysql://localhost:3306/iii?user=root&password=root";
		String url2 = "jdbc:mysql://localhost:3306/iii";
		
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		String sqlInsert = """
				INSERT INTO cust
					(cname, tel, birthday)
				VALUES
					(?,?,?)
				""";
		
		
		try (Connection conn = DriverManager.getConnection(url2, "root", "root");){
		
			PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
			pstmt.setString(1, "Mark");
			pstmt.setString(2, "123456");
			pstmt.setString(3, "1999-10-10");
			int n = pstmt.executeUpdate();
			System.out.println("OK:" + n);
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}

}
