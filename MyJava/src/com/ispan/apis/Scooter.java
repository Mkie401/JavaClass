// 增加屬性
package com.ispan.apis;

public class Scooter extends Bike {
	private int gear;
	
	public Scooter(){
		System.out.println("Scooter()");
	}
	
//	@override // 提醒要做什麼 改寫
	public Scooter upSpeed() {
		speed = speed < 1 ? 1 : speed * gear;
		return this;
	}
	
	public void upSpeed(int level) {
		speed = speed < 1 ? 1 : speed * level;
	}
	
	public void setGear(int gear) {
		// this 表示本類別
		if (gear >=0 && gear <= 6) {
			this.gear = gear;
		}
		
	}

	public int getGear() {
		return gear;
	}
}
