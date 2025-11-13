package com.ispan.tutor;

import java.util.LinkedList;
import java.util.List;

public class Hole38 {
	public static void main(String[] args) {
		LinkedList<String> names = new LinkedList<>();
		names.addFirst("A");
		names.addFirst("B");
		names.addFirst("C");
		names.addFirst("D");
		names.addFirst("E");
		names.addFirst("F");
		System.out.println(names);
		System.out.println("-----");
		for (String name : names) {
			System.out.println(name);
		}
	}

}
