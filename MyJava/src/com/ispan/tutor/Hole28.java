package com.ispan.tutor;

public class Hole28 {

	public static void main(String[] args) {
		
	}
class Hole281 {
	{System.out.println("Hole281:{}");}
	static {System.out.println("Hole281:static{}");} // static 只要呼叫 就一定會載入一次
	Hole281() {System.out.println("Hole281()");}
	void m1() {System.out.println("Hole281.m1()");}
	static void m2() {System.out.println("Hole281.m2()");}
}
}
