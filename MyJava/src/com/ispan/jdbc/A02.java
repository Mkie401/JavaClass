package com.ispan.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class A02 {

	public static void main(String[] args) {
					//jdbc 跟 mysql 資料庫連接 mysql 資料庫跟 本機 連接
					//資料庫名稱iii 帳號root 密碼root key=values
		String url1 = "jdbc:mysql://localhost:3306/iii?user=root&password=root";
		String url2 = "jdbc:mysql://localhost:3306/iii";
		
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		//Connection conn1 = DriverManager.getConnection(url1);
		
		//Connection conn3 = DriverManager.getConnection(url2, prop);
		
		String sqlInsert = """
				INSERT INTO cust 
					(cname, tel, birthday) 
				VALUES 
					('Tony', '12345678', '1999-04-05'),
					('Amy', '123', '1999-04-05'),
					('Peter', '123', '1999-04-05')
				""";
		

		String sqlUpdate = """
				UPDATE cust
				SET
					cname = 'Lebron',
					tel = '333'
				WHERE id = 3
				""";
		
		String sqlDel = """
				DELETE FROM cust
				WHERE id >= 5
				""";
		
		try (Connection conn2 = DriverManager.getConnection(url2, "root", "root");){
			Statement stmt = conn2.createStatement();
			int n = stmt.executeUpdate(sqlDel);
			
			System.out.println("ok:" + n);
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}

}
