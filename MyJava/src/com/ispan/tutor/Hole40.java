package com.ispan.tutor;

public class Hole40 {
	
	public static void main(String[] args) {
		int a = 10, b = 3;
		int c;
		int[] d = {1,2,3,4};
		// 抓出數學例外
		try {
		c = a / b;
		System.out.println(c);
		System.out.println(d[100]);
		//如果發生數學例外
		}catch(ArithmeticException e) {
			c = 0; // 做指定的事
		}catch(ArrayIndexOutOfBoundsException ee) {
			System.out.println("oops!");
		}
	}
}
