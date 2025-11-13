package com.ispan.jdbc;

import org.mindrot.jbcrypt.BCrypt;

public class A08 {

	public static void main(String[] args) {
		String passwd = "123456";
		String hashpasswd = BCrypt.hashpw(passwd, BCrypt.gensalt());
		System.out.println(hashpasswd);
		String input = "123456";
		if (BCrypt.checkpw(input, hashpasswd)) {
			System.out.println("ok");
		} else {
			System.out.println("xx");
		}

	}

}
