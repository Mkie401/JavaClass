package com.ispan.tutor;

public class Hole07 {

	public static void main(String[] args) {
		double temp = Math.random(); // 由於隨機數是浮點數所以要使用 double
		//System.out.println(temp);
		
		
		int score = (int)(temp * 101); // 101 -> 產生從 0 開始 101 個數字
		System.out.println(score);
		
		
		if (score >= 90) {
			System.out.println("A");
		} else if (score >= 80) {
			System.out.println("B");
		} else if (score >= 70) {
			System.out.println("C");
		} else if (score >= 60) {
			System.out.println("D");
		} else {
			System.out.println("E");
		}
				

	}

}
