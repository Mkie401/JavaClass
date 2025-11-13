package com.ispan.jdbc;

public class A01 {

	public static void main(String[] args) {
		// Load Driver(skip)
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("ok");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		
		
		// Connection
		
		
		// SQL

	}

}
