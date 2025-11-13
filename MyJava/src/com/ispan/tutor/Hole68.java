package com.ispan.tutor;

public class Hole68 {

	public static void main(String[] args) {
		Hole681 obj1 = new Hole681("A");
		Hole681 obj2 = new Hole681("B");
		Hole682 obj3 = new Hole682("C");
		Thread t1 = new Thread(obj3);
		System.out.println("main start");
		obj1.start();
		obj2.start();
		t1.start();
		System.out.println("main finish");

	}

}

class Hole681 extends Thread {
	private String name;
	Hole681(String name) {this.name = name;}
	void m1() {
		System.out.println("Hole681:m1()");
	}
	@Override
	public void run() {
		for (int i=0; i<10;i++) {
			System.out.println(name + ":" +i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
			}
		}
	}
}

class Hole682 implements Runnable {
	private String name;
	Hole682(String name) {this.name = name;}
	void m1() {
		System.out.println("Hole682:m1()");
	}
	@Override
	public void run() {
		for (int i=0; i<10;i++) {
			System.out.println(name + ":" +i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
			}
		}
	}
}