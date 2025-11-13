package com.ispan.tutor;

public class Hole10 {

	public static void main(String[] args) {
		int i = 0;
		for( printBrad(); i < 10; printLine()) {
			System.out.println(i++);
		}
		System.out.println("-----");
		System.out.println(i);
	}
	static void printBrad() {
		System.out.println("AssHole");
	}
	
	static void printLine() {
		System.out.println("-------");
	}
}
