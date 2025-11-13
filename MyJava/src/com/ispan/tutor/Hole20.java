// 物件導向
package com.ispan.tutor;

import com.ispan.apis.Bike;

public class Hole20 {
	
	public static void main(String[] args) {
		Bike b1 = new Bike(); // 初始化
		Bike b2 = new Bike(); // 初始化
		System.out.println(b1.getSpeed());
		System.out.println(b2.getSpeed());
		System.out.println("-----");
		
		b1.upSpeed();b1.upSpeed();b1.upSpeed();b1.upSpeed();
		b2.downSpeed();b2.downSpeed();b2.downSpeed();
		System.out.println(b1.getSpeed());
		System.out.println(b2.getSpeed());
		System.out.println("-----");
		//for (;b1.getSpeed()<20; b1.upSpeed())
		
		System.out.println(b1);
		System.out.println(b2);
		
	}
}
