package com.ispan.tutor;

public class Hole33 {

	public static void main(String[] args) {
		
	}

}
// interface 永遠是 public
interface Hole331 {
	void m1();
	void m2();
	void m3();
}

class Hole332 implements Hole331 {
	public void m1() {}
	public void m2() {}
	public void m3() {}
}

interface Hole333 {
	void m4();
}

// 可以繼承多個父類別
interface Hole334 extends Hole331, Hole333 {
	void m5();
}

class Hole335 implements Hole333,Hole334 {

	@Override
	public void m1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m3() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m5() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m4() {
		// TODO Auto-generated method stub
		
	}
	
}















