package com.ispan.jdbc;


import java.sql.Connection;
import java.util.List;

import com.ispan.apis.Member;
import com.ispan.apis.MemberDAO;
import com.ispan.apis.MemberDAOimpl;
import com.ispan.apis.Utils;

public class A17 {

	public static void main(String[] args) {
		try(Connection conn = Utils.getConnection()) {
			MemberDAO dao = new MemberDAOimpl(conn);
			
			String account = "ODK";
			String passwd = "123456";
			Member member = dao.login(account, passwd);
			if (member != null) {
				System.out.println("帳號正確");
			} else {
				System.out.println("帳號錯誤");
			}
			
		}catch (Exception e) {
			System.out.println("xx");
		}

	}

}
