package com.ispan.tutor;

public class Hole08 {

	public static void main(String[] args) {
		int a = 10, b = 3;
		if(a++ <= 10 && b-- >= 3) {
			System.out.printf("ok; a = %d, b = %d", a, b);
	}else{
		System.out.printf("XX; a = %d, b = %d", a, b);
	}
   }
}
