package com.ispan.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ispan.apis.testutils;

public class testdb {

	public static void main(String[] args) {
		String sql = """
				SELECT name FROM member
				""";
		
		try (Connection conn = testutils.getconnection();){
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet sqlinfo = pstmt.executeQuery();
			sqlinfo.absolute(2);
		
			System.out.println(sqlinfo.getString("name"));
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
