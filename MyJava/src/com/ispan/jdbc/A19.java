package com.ispan.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import com.ispan.apis.Member;
import com.ispan.apis.MemberDAO;
import com.ispan.apis.MemberDAOimpl;
import com.ispan.apis.Utils;

public class A19 {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = Utils.getConnection();
			conn.setAutoCommit(false);
			MemberDAO dao = new MemberDAOimpl(conn);
			
			Member m1 = dao.findById(4);
			Member m2 = dao.findById(5);
			
			m1.setName("test1");
			dao.updateMember(m1);

			m2.setName("test2");
			dao.updateMember(m2);
			
			conn.commit();
			System.out.println("ok");
		}catch(Exception e) {
			System.out.println(e);
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.out.println(e1);
				}
			}
		}

	}

}
