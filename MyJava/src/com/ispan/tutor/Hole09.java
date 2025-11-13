package com.ispan.tutor;

public class Hole09 {

	public static void main(String[] args) {
		int year = 2025;
		if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){
			System.out.println("閏年");
		}else {
			System.out.println("平年");
		}
}
}