package com.ispan.tutor;

public class Hole26 {

	public static void main(String[] args) {
		String s1 = "資策會";
		System.out.println(s1);
		String s2 = s1.concat("ok");
		System.out.println(s1.concat("ok"));
		System.out.println(s1);
		String s3 = s1 + "ok";
		System.out.println(s1 == s3);
		System.out.println(s1 == s2);
		System.out.println(s1.length());
	}

}
