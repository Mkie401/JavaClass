package com.ispan.jdbc;


import java.sql.Connection;
import java.util.List;

import com.ispan.apis.Member;
import com.ispan.apis.MemberDAO;
import com.ispan.apis.MemberDAOimpl;
import com.ispan.apis.Utils;

public class A16 {

	public static void main(String[] args) {
		try(Connection conn = Utils.getConnection()) {
			MemberDAO dao = new MemberDAOimpl(conn);
//			
//			Member member = new Member();
//			member.setAccount("Judy");
//			member.setPasswd("123456");
//			member.setName("Judy");
//			if (dao.addMember(member)) {
//				System.out.println("ok");
//			} else {
//				System.out.println("xx");
//			}
//			
//			Member m3 = dao.findById(3);
//			System.out.println(m3.getAccount() + ":" + m3.getName());
			
			List<Member> members = dao.findAll();
			for (Member member : members) {
				
			}
		}catch (Exception e) {
			System.out.println("xx");
		}

	}

}
