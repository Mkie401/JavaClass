package com.ispan.tutor;

import com.ispan.apis.Bike;
import com.ispan.apis.Scooter;

public class Hole25 {

	public static void main(String[] args) {
		
		String s0 =new String();
		String s1 = "Home";
		String s2 = "Home";
		String s3 =new String("Homo");
		String s4 =new String("Homo");

		System.out.println(s1.equals(s4));
		Bike b1 = new Bike();
		Bike b2 = new Bike();
		System.out.println(b1 == b2);
		System.out.println(b1.equals(b2));
		
		
		
	
//		String s1 = "Homo";
//		System.out.println("Homo".charAt(0));
//		String s2 = "Homo";
//		System.out.println(s1 == s2);
//		Bike b1 = new Bike();
//		Bike b2 = new Bike();
//		System.out.println(b1 == b2);
//		Scooter st1 = new Scooter();
//		Scooter st2 = new Scooter();
//		System.out.println(st1);
//		System.out.println(st2);
//		System.out.println(st1 == st2);
		
	}

}
