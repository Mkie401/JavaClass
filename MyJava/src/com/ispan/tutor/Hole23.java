package com.ispan.tutor;

public class Hole23 {

	public static void main(String[] args) {
		Hole123 obj1 = new Hole123(1);
		Hole124 obj2 = new Hole124();

	}
}
	class Hole123 extends Object {
		Hole123(int a){
			System.out.println("Hole(int)");
		}
		Hole123(){
			this(2);
			System.out.println("123");
		}
	}
	
	class Hole124 extends Hole123 {
		Hole124(){
			//super(5);
			System.out.println("124");
		}
	}

