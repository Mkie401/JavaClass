package com.ispan.tutor;

public class Hole17 {

	public static void main(String[] args) {
		int[][] ary; // 宣告一個二維陣列
		ary = new int[2][3]; // 初始化陣列值
		System.out.println(ary[0][1]);
		System.out.println("----");
		int[][] a = new int[3][];
		a[0] = new int[2];
		a[1] = new int[3];
		a[2] = new int[4];
		System.out.println(a);
		System.out.println(a[0]);
		System.out.println(a[2].length);

	}
}
