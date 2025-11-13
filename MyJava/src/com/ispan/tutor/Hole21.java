// 物件導向
package com.ispan.tutor;

import com.ispan.apis.Scooter;

public class Hole21 {

	public static void main(String[] args) {
		Scooter s1 = new Scooter();
		System.out.println(s1.getSpeed());
		s1.setGear(6);
		s1.upSpeed();s1.upSpeed();s1.upSpeed();s1.upSpeed();
		System.out.println(s1.getSpeed());

	}

}
