// 物件導向 如果有回傳值 return 的話 可以使用 b1.upSpeed().upSpeed().upSpeed();
package com.ispan.tutor;

import com.ispan.apis.Bike;

public class Hole30 {

	public static void main(String[] args) {
		Bike b1 = new Bike();
		b1.upSpeed().upSpeed().upSpeed();
		System.out.println(b1.getSpeed());

	}

}
