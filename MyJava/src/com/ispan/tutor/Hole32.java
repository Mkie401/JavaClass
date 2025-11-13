// 抽象方法 abstract
package com.ispan.tutor;

public class Hole32 {

	public static void main(String[] args) {
		Hole321 obj2 = new Hole322();
		obj2.m1();obj2.m2();obj2.m3();
		
		// 直接在裡面定義
		Hole321 obj3 = new Hole321() {
			void m3() {System.out.println("Hole321:m3()");}
		};
		obj3.m3();
	}

}

// 如果類別裡面有抽象方法 要在外面宣告
abstract class Hole321 {
	void m1() {
		System.out.println("Hole321:m1()");
	}
	void m2() {
		System.out.println("Hole321:m2()");
	}
	abstract void m3();
}

class Hole322 extends Hole321 {
	void m3() {System.out.println("Hole322:m3()");}
}






