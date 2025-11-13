// 創造多形
package com.ispan.tutor;

public class Hole34 {

	public static void main(String[] args) {
		order order1 = new order1("P001",200);
		order order2 = new order2("P002",210);
		order1.paid(); order1.notifyCust(); order1.process();
		System.out.println("--------");
		order2.paid(); order2.notifyCust(); order2.process();

	}

}

interface shipable {
	void ship();
}

abstract class order {
	private String orderId;
	private int amount;
	order(String orderId, int amount) {
		this.orderId = orderId; this.amount = amount;
	}
	void paid() {
		System.out.println("付款了");
	}
	void notifyCust() {
		System.out.println("通知客戶");
	}
	abstract void process();
}

class order1 extends order {
	order1(String orderId, int amount) {
		super(orderId,amount);
	}

	@Override
	void process() {
		System.out.println("數位商品出貨了");
	}
}

class order2 extends order implements shipable {
	order2(String orderId, int amount) {
		super(orderId,amount);
	}

	@Override
	void process() {
		ship();
		System.out.println("實體商品出貨了");
	}

	@Override
	public void ship() {
		System.out.println("實體商品寄出了");
	}
}




